package src.com.hu.bms.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;
import src.com.hu.bms.pojo.Shopcart;
import src.com.hu.bms.utils.JdbcUtils;
import src.com.hu.bms.utils.PageResult;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class ShopcartDaoImpl implements src.com.hu.bms.dao.ShopcartDao {
    private QueryRunner qr;

    public ShopcartDaoImpl() {
        qr=new QueryRunner(JdbcUtils.getDataSource());
    }

    //根据gid查询是否有
    @Override
    public Shopcart findBYGoodsId(String bno) {
        String sql = "select * from shopcart where gid = ?";
        try {
            return qr.query(sql,bno,new BeanHandler<Shopcart>(Shopcart.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //添加
    @Override
    public void addGoods(String bno) {
        String sql = "INSERT INTO shopcart VALUES (NULL,?,1,0)";
        try {
            qr.update(sql,bno);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //已有添加数目购物车
    @Override
    public void updateGoods(String bno, int i) {
        String sql ="UPDATE shopcart SET goodnums = goodnums + ? where gid =?";
        try {
            qr.update(sql, i,bno);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //购物车信息
    @Override
    public PageResult<Shopcart> findAllByPage(int page, int pageSize) {
        String sql ="SELECT sc.`sid`, b.`bname` gname,sc.`goodnums`,b.`zprice`*sc.`goodnums` goodsprice " +
                "FROM shopcart sc, book b WHERE sc.`gid` = b.`bno` limit ?,? ";
        List<Shopcart> list = null;
        long totalCount = 0;

        try {
            list = qr.query(sql,new BeanListHandler<>(Shopcart.class),(page-1)*pageSize,pageSize);
            totalCount = (long)qr.query("select count(*) from shopcart",new ScalarHandler());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        long totalPages = (long)Math.ceil(totalCount/(double)pageSize);
        return new PageResult<>(list,page,totalPages,totalCount);
    }

    @Override
    public Map<String, Object> finPriceAndNums() {
        String sql = "SELECT SUM(sc.`goodnums`) snums,SUM(b.`zprice`*sc.`goodnums`) sprice " +
                "FROM shopcart sc, book b WHERE sc.`gid` = b.`bno`; ";
        try {
            return  qr.query( sql, new MapHandler());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void deleteAll() {
        String sql = "TRUNCATE shopcart ";
        try {
            qr.update(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    @Override
    public void deleteBySid(String sid) {
        String sql = "delete from shopcart where sid = ?";
        try {
            qr.update(sql,sid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void deleteOne(String sid) {
        String sql = "update  shopcart set goodnums = goodnums-1 where sid = ?";
        try {
            qr.update(sql,sid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
