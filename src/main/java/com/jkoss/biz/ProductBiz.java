package com.jkoss.biz;

import java.util.List;

import javax.transaction.Transactional;

import com.jkoss.pojo.Product;
import com.jkoss.pojo.User;
import com.jkoss.tool.Page;

public interface ProductBiz {

	
	
	//��ҳ��ѯ
	List<Product> findAtPage(Page page);
	
	//��ҳ��
	int findAllPage();
	
	
	//��Ӳ�Ʒ

	void addPro(Product pro);
	
	
	//��ѯ����
	Product findProByID(int proid);
	
	//�����û�
//	void updateUser(User usr);
}
