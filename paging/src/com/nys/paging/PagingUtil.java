package com.nys.paging;

import com.nys.paging.bean.PageBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PagingUtil {
    public static PageBean getPageBean(PageBean pageBean, List<?> lists, int pc, int count){
        return getPageBean(pageBean,lists,pc,count,null,null);
    }

    public static PageBean getPageBean(
            PageBean pageBean, List<?> lists, int pc, int count
            ,String[] params,String[] values
    ){
        if (params!=null&&values!=null){
            Map<String,String> postParam = new HashMap<>();
            for (int i = 0; i < values.length; i++) {
                postParam.put(params[i],values[i]);
            }
            pageBean.setParams(postParam);

            StringBuilder sb = new StringBuilder();
            boolean isFirst = true;
            for (int i = 0; i < values.length; i++) {
                if (values[i]!=null&&!values[i].equals("")){
                    sb.append("&"+params[i]+"="+values[i]);
                }
            }
            String getParam = sb.toString();
            pageBean.setParam(getParam);
        }



        int size = pageBean.getPageSize();
        int totalPage = count/size;
        if (count%size>0){
            totalPage = totalPage+1;
        }
        if (pc>totalPage){
            pc=totalPage;
        }
        int begin = (pc-1)*size;
        pageBean.setLists(lists);
        pageBean.setTotalPage(totalPage);
        pageBean.setCurrentPage(pc);



        return pageBean;
    }
}
