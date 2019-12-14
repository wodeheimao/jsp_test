package com.hu.bms.dao;

import com.hu.bms.pojo.Commentb;

import java.util.List;

public interface CommentDao {
    List<Commentb> finAll(String bno);

    void addComment(Commentb commentb);
}
