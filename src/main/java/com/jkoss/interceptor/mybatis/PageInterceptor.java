package com.jkoss.interceptor.mybatis;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;

import com.jkoss.tool.Page;
import com.jkoss.tool.ReflectUtil;

/**
 * 
 * ��ҳ������������������Ҫ���з�ҳ��ѯ�Ĳ�����Ȼ�������з�ҳ���� ����������ʵ��Mybatis��ҳ��ԭ��
 * Ҫ����JDBC�����ݿ���в����ͱ���Ҫ��һ����Ӧ��Statement����
 * ��Mybatis��ִ��Sql���ǰ�ͻ����һ������Sql����Statement���󣬶��Ҷ�Ӧ��Sql���?
 * ����Statement֮ǰ�����ģ��������ǾͿ�����������Statement֮ǰ����������Statement��Sql�������?
 * ����Mybatis��Statement�����ͨ��RoutingStatementHandler�����?
 * prepare�������ɵġ���������������ʵ��Mybatis��ҳ��һ��˼·��������StatementHandler�ӿڵ�prepare����
 * ��Ȼ���������������а�Sql���ĳɶ�Ӧ�ķ�ҳ��ѯSql��䣬֮���ٵ���?
 * StatementHandler�����prepare������������invocation.proceed()��
 * ���ڷ�ҳ���ԣ����������������ǻ���Ҫ����һ����������ͳ�����㵱ǰ�����ļ�¼һ���ж���
 * ������ͨ����ȡ����ԭʼ��Sql���󣬰�����Ϊ��Ӧ��ͳ�����������Mybatis��װ�õĲ�������
 * �ò����Ĺ��ܰ�Sql����еĲ��������滻��֮����ִ�в�ѯ��¼����Sql�������ܼ�¼����ͳ�ơ�
 * 
 */
@Intercepts({ @Signature(method = "prepare", type = StatementHandler.class, args = { Connection.class }) })
public class PageInterceptor implements Interceptor {

	private String databaseType;// ���ݿ����ͣ���ͬ�����ݿ��в�ͬ�ķ�ҳ����

	/**
	 * ���غ�Ҫִ�еķ���
	 */
	public Object intercept(Invocation invocation) throws Throwable {
		// ����StatementHandler��ʵֻ������ʵ���࣬һ����RoutingStatementHandler����һ���ǳ�����BaseStatementHandler��
		// BaseStatementHandler���������࣬�ֱ���SimpleStatementHandler��PreparedStatementHandler��CallableStatementHandler��
		// SimpleStatementHandler�����ڴ���Statement�ģ�PreparedStatementHandler�Ǵ���PreparedStatement�ģ���CallableStatementHandler��
		// ����CallableStatement�ġ�Mybatis�ڽ���Sql��䴦���ʱ���ǽ�����RoutingStatementHandler������RoutingStatementHandler����ӵ��һ��
		// StatementHandler���͵�delegate���ԣ�RoutingStatementHandler������Statement�Ĳ�ͬ������Ӧ��BaseStatementHandler����SimpleStatementHandler��
		// PreparedStatementHandler��CallableStatementHandler����RoutingStatementHandler��������StatementHandler�ӿڷ�����ʵ�ֶ��ǵ��õ�delegate��Ӧ�ķ�����
		// ������PageInterceptor�����Ѿ���@Signature����˸�Interceptorֻ����StatementHandler�ӿڵ�prepare����������ΪMybatisֻ���ڽ���RoutingStatementHandler��ʱ��
		// ��ͨ��Interceptor��plugin�������а����ģ����������������ص���Ŀ�����϶���RoutingStatementHandler����
		RoutingStatementHandler handler = (RoutingStatementHandler) invocation
				.getTarget();
		// ͨ�������ȡ����ǰRoutingStatementHandler�����delegate����
		StatementHandler delegate = (StatementHandler) ReflectUtil
				.getFieldValue(handler, "delegate");
		// ��ȡ����ǰStatementHandler��
		// boundSql�����ﲻ���ǵ���handler.getBoundSql()����ֱ�ӵ���delegate.getBoundSql()�����һ���ģ���Ϊ֮ǰ�Ѿ�˵����?
		// RoutingStatementHandlerʵ�ֵ�����StatementHandler�ӿڷ������涼�ǵ��õ�delegate��Ӧ�ķ�����
		BoundSql boundSql = delegate.getBoundSql();
		// �õ���ǰ��Sql�Ĳ������󣬾��������ڵ��ö�Ӧ��Mapperӳ�����ʱ������Ĳ�������
		Object obj = boundSql.getParameterObject();
		// �������Ǽ򵥵�ͨ���������Page������϶�������Ҫ���з�ҳ�����ġ�?
		if (obj instanceof Page<?>) {
			Page<?> page = (Page<?>) obj;
			// ͨ�������ȡdelegate����BaseStatementHandler��mappedStatement����
			MappedStatement mappedStatement = (MappedStatement) ReflectUtil
					.getFieldValue(delegate, "mappedStatement");
			// ���ص���prepare����������һ��Connection����
			Connection connection = (Connection) invocation.getArgs()[0];
			// ��ȡ��ǰҪִ�е�Sql��䣬Ҳ��������ֱ����Mapperӳ�������д��Sql���?
			String sql = boundSql.getSql();
			// ����ǰ��page�������������ܼ�¼��
			this.setTotalRecord(page, mappedStatement, connection);
			// ��ȡ��ҳSql���?
			String pageSql = this.getPageSql(page, sql);
			// ���÷������õ�ǰBoundSql��Ӧ��sql����Ϊ���ǽ����õķ�ҳSql���?
			ReflectUtil.setFieldValue(boundSql, "sql", pageSql);
		}
		return invocation.proceed();
	}

	/**
	 * ��������Ӧ�ķ�װԭʼ����ķ���?
	 */
	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	/**
	 * ����ע��������ʱ�趨������
	 */
	public void setProperties(Properties properties) {
		this.databaseType = properties.getProperty("databaseType");
	}

	/**
	 * ����page�����ȡ��Ӧ�ķ�ҳ��ѯSql��䣬����ֻ�����������ݿ����ͣ�Mysql��Oracle ���������ݿⶼ û�н��з�ҳ
	 * 
	 * @param page
	 *            ��ҳ����
	 * @param sql
	 *            ԭsql���?
	 * @return
	 */
	private String getPageSql(Page<?> page, String sql) {
		StringBuffer sqlBuffer = new StringBuffer(sql);
		if ("mysql".equalsIgnoreCase(databaseType)) {
			return getMysqlPageSql(page, sqlBuffer);
		} else if ("oracle".equalsIgnoreCase(databaseType)) {
			return getOraclePageSql(page, sqlBuffer);
		}
		return sqlBuffer.toString();
	}

	/**
	 * ��ȡMysql���ݿ�ķ�ҳ��ѯ���
	 * 
	 * @param page
	 *            ��ҳ����
	 * @param sqlBuffer
	 *            ����ԭsql����StringBuffer����
	 * @return Mysql���ݿ��ҳ���
	 */
	private String getMysqlPageSql(Page<?> page, StringBuffer sqlBuffer) {
		// �����һ����¼��λ�ã�Mysql�м�¼��λ���Ǵ�0��ʼ�ġ�
		int offset = (page.getPageNo() - 1) * page.getPageSize();
		sqlBuffer.append(" limit ").append(offset).append(",")
				.append(page.getPageSize());
		return sqlBuffer.toString();
	}

	/**
	 * ��ȡOracle���ݿ�ķ�ҳ��ѯ���
	 * 
	 * @param page
	 *            ��ҳ����
	 * @param sqlBuffer
	 *            ����ԭsql����StringBuffer����
	 * @return Oracle���ݿ�ķ�ҳ��ѯ���
	 */
	private String getOraclePageSql(Page<?> page, StringBuffer sqlBuffer) {
		// �����һ����¼��λ�ã�Oracle��ҳ��ͨ��rownum���еģ���rownum�Ǵ�1��ʼ��
		int offset = (page.getPageNo() - 1) * page.getPageSize() + 1;
		sqlBuffer.insert(0, "select u.*, rownum r from (")
				.append(") u where rownum < ")
				.append(offset + page.getPageSize());
		sqlBuffer.insert(0, "select * from (").append(") where r >= ")
				.append(offset);
		// �����Sql���ƴ��֮������������ӣ�
		// select * from (select u.*, rownum r from (select * from t_user) u
		// where rownum < 31) where r >= 16
		return sqlBuffer.toString();
	}

	/**
	 * ����ǰ�Ĳ�������page�����ܼ�¼��
	 * 
	 * @param page
	 *            Mapperӳ������Ӧ�Ĳ�������
	 * @param mappedStatement
	 *            Mapperӳ�����?
	 * @param connection
	 *            ��ǰ�����ݿ�����
	 */
	private void setTotalRecord(Page<?> page, MappedStatement mappedStatement,
			Connection connection) {
		// ��ȡ��Ӧ��BoundSql�����BoundSql��ʵ����������StatementHandler��ȡ����BoundSql��ͬһ������
		// delegate�����boundSqlҲ��ͨ��mappedStatement.getBoundSql(paramObj)������ȡ���ġ�
		BoundSql boundSql = mappedStatement.getBoundSql(page);
		// ��ȡ�������Լ�д��Mapperӳ������ж�Ӧ��Sql���?
		String sql = boundSql.getSql();
		// ͨ����ѯSql����ȡ����Ӧ�ļ����ܼ�¼����sql���?
		String countSql = this.getCountSql(sql);
		// ͨ��BoundSql��ȡ��Ӧ�Ĳ���ӳ��
		List<ParameterMapping> parameterMappings = boundSql
				.getParameterMappings();
		// ����Configuration����ѯ��¼����Sql���countSql������ӳ���ϵparameterMappings�Ͳ�������page������ѯ��¼����Ӧ��BoundSql����
		BoundSql countBoundSql = new BoundSql(
				mappedStatement.getConfiguration(), countSql,
				parameterMappings, page);
		// ͨ��mappedStatement����������page��BoundSql����countBoundSql����һ�������趨������ParameterHandler����
		ParameterHandler parameterHandler = new DefaultParameterHandler(
				mappedStatement, page, countBoundSql);
		// ͨ��connection����һ��countSql��Ӧ��PreparedStatement����
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = connection.prepareStatement(countSql);
			// ͨ��parameterHandler��PreparedStatement�������ò���
			parameterHandler.setParameters(pstmt);
			// ֮�����ִ�л�ȡ�ܼ�¼����Sql���ͻ�ȡ����ˡ�?
			rs = pstmt.executeQuery();
			if (rs.next()) {
				int totalRecord = rs.getInt(1);
				// ����ǰ�Ĳ���page���������ܼ�¼��
				page.setTotalRecord(totalRecord);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * ����ԭSql����ȡ��Ӧ�Ĳ�ѯ�ܼ�¼����Sql���?
	 * 
	 * @param sql
	 * @return
	 */
	private String getCountSql(String sql) {

		return "select count(1) from (" + sql + ") xs";
	}

	

}