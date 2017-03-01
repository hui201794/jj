package com.jkoss.tool;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * ��ҳ��ǩ
 * 
 * @author liubao
 * 
 */
public class PageTag extends SimpleTagSupport {

	private int pageNo;// ��ǰҳ
	private int totalPage;// ��ҳ��
	private int totalRecord;// ����Ŀ��

	private String url;// ����url�ķ�ʽ

	@Override
	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		StringBuffer sb = new StringBuffer();

		url = getFormatUrl(url);

		if (this.pageNo == 1) {
			// sb.append("��ҳ");
		} else {
			sb.append("<a href=\"" + url + "pageNo=1\">��ҳ</a>");
		}
		sb.append("&nbsp;&nbsp;");
		if (this.pageNo == 1) {
			// sb.append("��һҳ");
		} else {
			sb.append("<a href=\"" + url + "pageNo="
					+ (pageNo - 1) + "\">ǰһҳ</a>");
		}
		sb.append("&nbsp;&nbsp;");
		if (totalPage <= this.pageNo) {
			// sb.append("��һҳ");
		} else {
			sb.append("<a href=\"" + url + "pageNo="
					+ (pageNo + 1) + "\">��һҳ</a>");
		}
		sb.append("&nbsp;&nbsp;");
		if (totalPage <= this.pageNo) {
			// sb.append("βҳ");
		} else {
			sb.append("<a href=\"" + url + "pageNo=" + totalPage
					+ "\">βҳ</a>");
		}

		sb.append("&nbsp;&nbsp;" + pageNo + "/" + totalPage );

		try {
			out.println(sb.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//
	private String getFormatUrl(String url) {
		if (url.indexOf("?") == -1) {
			return url.concat("?");
		} else {
			return url.concat("&");
		}

	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getpageNo() {
		return pageNo;
	}

	public void setpageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int gettotalPage() {
		return totalPage;
	}

	public void settotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int gettotalRecord() {
		return totalRecord;
	}

	public void settotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

}
