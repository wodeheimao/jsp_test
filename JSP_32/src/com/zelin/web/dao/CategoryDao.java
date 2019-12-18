package com.zelin.web.dao;



import com.zelin.web.pojo.Category;

import java.util.List;

public interface CategoryDao {
    List<Category> findAll(String bno);
}
