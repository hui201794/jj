package com.jkoss.dao;

import com.jkoss.pojo.Productimage;

public interface ProductimageMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table productimage
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer productImageId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table productimage
     *
     * @mbggenerated
     */
    int insert(Productimage record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table productimage
     *
     * @mbggenerated
     */
    int insertSelective(Productimage record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table productimage
     *
     * @mbggenerated
     */
    Productimage selectByPrimaryKey(Integer productImageId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table productimage
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Productimage record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table productimage
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Productimage record);
}