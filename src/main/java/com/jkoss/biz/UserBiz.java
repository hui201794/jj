package com.jkoss.biz;

import java.util.List;

import com.jkoss.pojo.User;
import com.jkoss.tool.Page;

public interface UserBiz {
	public User login(String un, String upwd);
	
	
	//��ҳ��ѯ
	List<User> findUserAtPage(Page page);
	
	//��ҳ��
	int findAllPage();
	
	//��ѯ����
	User findUserByID(int userId);
	
	//�����û�
	void updateUser(User usr);
	
	//ɾ���û�
	void deleteUsr(int userid);
	
}
