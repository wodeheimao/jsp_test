package com.zelin.web.dao;

import com.zelin.web.pojo.Telvisit;

import java.util.List;

public interface TelvisitDao {
    List<Telvisit> findByCno(String cno);

    void addTel(Telvisit telvisit);

}
