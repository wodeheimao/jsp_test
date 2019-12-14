package src.com.hu.bms.dao;

import src.com.hu.bms.pojo.Shopcart;
import src.com.hu.bms.utils.PageResult;

import java.util.Map;

public interface ShopcartDao {
    void addGoods(String bno);

    Shopcart findBYGoodsId(String bno);

    void updateGoods(String bno, int i);

    PageResult<Shopcart> findAllByPage(int page, int pageSize);

    Map<String,Object> finPriceAndNums();

    void deleteAll();

    void deleteBySid(String sid);

    void deleteOne(String sid);
}
