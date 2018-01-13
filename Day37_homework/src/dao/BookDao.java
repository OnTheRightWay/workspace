package dao;

import domain.Book;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import util.DBCPUtil;

import java.sql.SQLException;
import java.util.List;

public class BookDao {
    private QueryRunner qr = DBCPUtil.getQuery();
    public List<Book> queryByParams(int begin, int count,
                                    String bname, String author, String price, String category){
        String[] prs = {"bname","author","price","category"};
        String[] pvs = {bname,author,price,category};
        StringBuilder sb = new StringBuilder();
        sb.append("select * from book ");
        if (bname!=null&&!bname.equals("")||author!=null&&!author.equals("")
                ||price!=null&&!price.equals("")||category!=null&&!category.equals("")){
            sb.append(" where ");
        }
        boolean isFirst = true;
        for (int i = 0; i < pvs.length; i++) {
            if (pvs[i]!=null&&!pvs[i].equals("")){
                if (!isFirst){
                    sb.append(" and ");
                }
                sb.append(prs[i]+"='"+pvs[i]+"'");
                isFirst=false;
            }
        }
        sb.append(" limit "+begin+","+count);
        String sql = sb.toString();
        List<Book> books = null;
        try {
            books = qr.query(
                    sql,
                    new BeanListHandler<Book>(Book.class)
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }
    public void insert(String bname,String author,Double price,String category){
        try {
            qr.update(
                    "insert into book values(null,?,?,?,?)",
                    bname,author,price,category
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public int queryCount(
                          String bname, String author, String price, String category) {
        long count = 0;
//        try {
//            count = qr.query(
//                    DBCPUtil.getConn(),
//                    "select count(*) from book",
//                    new ScalarHandler<Long>()
//            );
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return (int) count;
//    }


        String[] prs = {"bname", "author", "price", "category"};
        String[] pvs = {bname, author, price, category};
        StringBuilder sb = new StringBuilder();
        sb.append("select count(*) from book ");
        if (bname != null && !bname.equals("") || author != null && !author.equals("")
                || price != null && !price.equals("") || category != null && !category.equals("")) {
            sb.append(" where ");
        }
        boolean isFirst = true;
        for (int i = 0; i < pvs.length; i++) {
            if (pvs[i] != null && !pvs[i].equals("")) {
                if (!isFirst) {
                    sb.append(" and ");
                }
                sb.append(prs[i] + "='" + pvs[i] + "'");
                isFirst = false;
            }
        }
        String sql = sb.toString();
        try {
            count = qr.query(
                    sql,
                    new ScalarHandler<Long>()
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (int) count;
    }
}
