package com.zelin.web.dao;

import com.zelin.web.pojo.Fatie;

import java.util.List;

public interface TieDao {
    List<Fatie> findAllTie();

    Fatie finOneByTid(String tid);

    void update(Fatie fatie);
}
