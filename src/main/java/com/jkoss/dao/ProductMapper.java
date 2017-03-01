package com.jkoss.dao;

import java.util.List;

import com.jkoss.pojo.Product;
import com.jkoss.tool.Page;

public interface ProductMapper {
   
    int deleteByPrimaryKey(Integer productId);


    int insert(Product record);

    int insertSelective(Product record);


    Product selectByPrimaryKey(Integer productId);

  
    int updateByPrimaryKeySelective(Product record);


    int updateByPrimaryKeyWithBLOBs(Product record);

   
    int updateByPrimaryKey(Product record);
    
    
    //查询所有产品的方法
    List<Product> AllPro(Page  page);
    
    
    //总页数
    int countAll();
    
    
}