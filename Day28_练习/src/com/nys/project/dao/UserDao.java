package com.nys.project.dao;

import com.nys.project.bean.Book;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class UserDao {

    public void insert(Book book){
//        String bkid = book.getBkid();
        String bkname = book.getBkname();
        String author = book.getAuthor();
        String tid = book.getTid();
        try {
            new QueryUtil().update(
                    JDBCUtil.getConnection(),
                    "insert into book values(null,?,?,?)",
                    bkname,author,tid
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<Book> query(){
        List<Book> books = null;
        try {
             books= new QueryUtil().query(
                    JDBCUtil.getConnection(),
                    "select * from book",
                    new BeanListHandler<Book>(Book.class)
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }
}
