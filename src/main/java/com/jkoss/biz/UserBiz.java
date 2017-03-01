package com.jkoss.biz;

import java.util.List;

import com.jkoss.pojo.User;
import com.jkoss.tool.Page;

public interface UserBiz {
	public User login(String un, String upwd);
	
	
	//分页查询
	List<User> findUserAtPage(Page page);
	
	//总页数
	int findAllPage();
	
	//查询单个
	User findUserByID(int userId);
	
	//更新用户
	void updateUser(User usr);
	
	//删除用户
	void deleteUsr(int userid);
	
}
