package com.imooc.mall.dao;

import com.imooc.mall.pojo.Category;
import java.util.List;
public interface CategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Category row);

    int insertSelective(Category row);

    Category selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Category row);

    int updateByPrimaryKey(Category row);

    List<Category> selectAll();
}