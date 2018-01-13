package service;

import dao.BookDao;
import domain.Book;

import java.util.List;

public class BookService {
    private BookDao bookDao = new BookDao();
    public List<Book> findByParams(
            int begin, int count,
            String bname, String author, String price, String category
    ){
        List<Book> books = bookDao.queryByParams(begin,count,
        bname,author,price,category);
        return books;
    }
}
