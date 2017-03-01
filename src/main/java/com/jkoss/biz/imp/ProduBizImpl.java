package com.jkoss.biz.imp;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jkoss.biz.ProductBiz;
import com.jkoss.dao.ProductMapper;
import com.jkoss.pojo.Product;
import com.jkoss.pojo.User;
import com.jkoss.tool.Page;


@Component
public class ProduBizImpl implements ProductBiz {

	
@Autowired
ProductMapper pdao;

	@Override
	public List<Product> findAtPage(Page page) {
		// TODO Auto-generated method stub
		return pdao.AllPro(page);
	}

	@Override
	public int findAllPage() {
		// TODO Auto-generated method stub
		return pdao.countAll();
	}

	@Transactional
	public void addPro(Product pro) {
		// TODO Auto-generated method stub
	            pdao.insertSelective(pro);
	}

	//²éÑ¯µ¥¸ö
	public Product findProByID(int proid) {
		// TODO Auto-generated method stub
		return pdao.selectByPrimaryKey(proid);
	}

}
