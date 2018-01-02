package com.nys.project.web;

import com.nys.project.bean.Book;
import com.nys.project.dao.QueryUtil;
import com.nys.project.dao.UserDao;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class QueryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.addHeader("Access-Control-Allow-Origin","*");
        resp.addHeader("Access-Control-Allow-Methods","POST");
        resp.addHeader("Access-Control-Allow-Headers","x-requested-with,content-type");
        resp.setContentType("text/html;charset=utf-8");
        UserDao userDao = new UserDao();
        List<Book> books = userDao.query();

        JSONArray jsonArray = JSONArray.fromObject(books);
        resp.getWriter().write(jsonArray.toString());

    }
}
