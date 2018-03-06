package com.nys.util;

import com.nys.cost.domain.Cost;
import com.nys.cost.domain.PageBean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PagingUtil {
    public PagingUtil() {
    }

    public static PageBean getPageBean(PageBean pageBean, List lists, int pc, int count) {
        return getPageBean(pageBean, lists, pc, count, (String[])null, (String[])null);
    }

    /**
     * 方法参数说明
     * @param pageBean 已经设置了pageSize的pageBean
     * @param lists 从数据库取得的，需要在页面显示的数据
     * @param pc 当前页码，从前端传入
     * @param count 从数据库取得的，符合多条件查询的数据的总数
     * @param params 多条件查询的参数名的字符串数组
     * @param values 多条件查询的参数值的字符串数组
     * @return
     */
    public static PageBean getPageBean(PageBean pageBean, List lists, int pc, int count, String[] params, String[] values) {
        int totalPage;
        if (params != null && values != null) {
            Map<String, String> postParam = new HashMap<>();

            for(totalPage = 0; totalPage < values.length; ++totalPage) {
                postParam.put(params[totalPage], values[totalPage]);
            }

            pageBean.setParams(postParam);
            StringBuilder sb = new StringBuilder();
            boolean isFirst = true;

            for(int i = 0; i < values.length; ++i) {
                if (values[i] != null && !values[i].equals("")) {
                    sb.append("&" + params[i] + "=" + values[i]);
                }
            }

            String getParam = sb.toString();
            pageBean.setParam(getParam);
        }

        int size = pageBean.getPageSize();
        totalPage = count / size;
        if (count % size > 0) {
            ++totalPage;
        }

        if (pc > totalPage) {
            pc = totalPage;
        }

        int begin = (pc - 1) * size;
        pageBean.setLists(lists);
        pageBean.setTotalPage(totalPage);
        pageBean.setCurrentPage(pc);
        return pageBean;
    }
}
