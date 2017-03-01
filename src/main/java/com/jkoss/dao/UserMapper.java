package com.jkoss.dao;

import java.util.List;

import com.jkoss.pojo.User;
import com.jkoss.tool.Page;

public interface UserMapper {

    int deleteByPrimaryKey(Integer userId);

    int dUser(int userId);
    
    int insert(User record);


    int insertSelective(User record);


    User selectByPrimaryKey(Integer userId);


    int updateByPrimaryKeySelective(User record);


    int updateByPrimaryKeyWithBLOBs(User record);


    int updateByPrimaryKey(User record);
    
    
    ////µÇÂ¼
   User    selectByName(String un);
    
   User  selectAtUser();
   
// ·ÖÒ³²éÑ¯
	List<User> selectAtUser(Page page);
	
	
   int  countAll();
   
}