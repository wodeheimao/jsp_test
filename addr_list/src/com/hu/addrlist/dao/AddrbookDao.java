package com.hu.addrlist.dao;

import com.hu.addrlist.pojo.Addrbook;
import com.hu.addrlist.utils.PageResult;

public interface AddrbookDao {
    PageResult<Addrbook> findAllPage(int page, int pageSize);
}
