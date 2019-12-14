package src.com.hu.bms.dao;
import src.com.hu.bms.pojo.Book;
import src.com.hu.bms.utils.PageResult;

public interface BookDao {
    PageResult<Book> findAllPage(int page, int pageSize, String bname, String publisher);
}
