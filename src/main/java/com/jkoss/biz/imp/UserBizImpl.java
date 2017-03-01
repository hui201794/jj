package com.jkoss.biz.imp;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jkoss.biz.UserBiz;
import com.jkoss.dao.UserMapper;
import com.jkoss.pojo.User;
import com.jkoss.tool.Page;

@Component
public class UserBizImpl implements UserBiz {

	@Autowired
	private UserMapper udao;

	public User login(String un, String upwd) {

		User tmp = udao.selectByName(un);

		if (tmp != null && tmp.getUserPwd().equals(upwd)) {
			return tmp;

		}
		return null;
	}

	@Override
	public List<User> findUserAtPage(Page page) {
		return udao.selectAtUser(page);

	}

	public int findAllPage() {
		return udao.countAll();
	}
	//查询单个
	public User findUserByID(int userId){
		return udao.selectByPrimaryKey(userId);
	}

	
	//更新
	@Transactional
	public void updateUser(User usr) {
		  udao.updateByPrimaryKey(usr);
		
	}
	

	@Transactional
	public void deleteUsr(int userid) {
		udao.deleteByPrimaryKey(userid);
		
	}
}
