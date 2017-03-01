package com.jkoss.biz;

import java.util.List;

import javax.transaction.Transactional;

import com.jkoss.pojo.Product;
import com.jkoss.pojo.User;
import com.jkoss.tool.Page;

public interface ProductBiz {

	
	
	//分页查询
	List<Product> findAtPage(Page page);
	
	//总页数
	int findAllPage();
	
	
	//添加产品

	void addPro(Product pro);
	
	
	//查询单个
	Product findProByID(int proid);
	
	//更新用户
//	void updateUser(User usr);
}
