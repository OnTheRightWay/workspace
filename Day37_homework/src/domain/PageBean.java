package domain;

import domain.Book;

import java.util.List;
import java.util.Map;

public class PageBean {
    //当前页
    private int currentPage;
    //对象集合
    private List<Book> books;
    //总页数
    private int totalPage;
    //每页大小
    private int pageSize = 10;
    //get拼接参数
    private String param;
    //参数集合，表单拼接参数
    private Map<String,String> params;

    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    public PageBean() {
    }

    public PageBean(int currentPage, List<Book> books, int totalPage, int pageSize, int pageCount, String param) {
        this.currentPage = currentPage;
        this.books = books;
        this.totalPage = totalPage;
        this.pageSize = pageSize;
        this.param = param;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "currentPage=" + currentPage +
                ", books=" + books +
                ", totalPage=" + totalPage +
                ", pageSize=" + pageSize +
                ", param='" + param + '\'' +
                '}';
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }
}
