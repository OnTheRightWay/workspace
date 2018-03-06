package com.nys.paging.bean;

import java.util.List;
import java.util.Map;

public class PageBean<T> {
    //当前页
    private int currentPage;
    //对象集合
    private List<T> lists;
    //总页数
    private int totalPage;
    //每页大小
    private int pageSize = 10;
    //get拼接参数
    private String param;
    //参数集合，表单拼接参数
    private Map<String,String> params;
    public String html="<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\n" +
            "  <tr>\n" +
            "    <td align=\"right\">\n" +
            "    \t<span>第${requestScope.pageBean.currentPage}/${requestScope.pageBean.totalPage}页</span>\n" +
            "        <span>\n" +
            "\t\t\t<c:set var=\"pageBean\" value=\"${requestScope.pageBean}\"/>\n" +
            "    <c:if test=\"${pageBean!=null}\">\n" +
            "\n" +
            "\t\t<f:formatNumber var=\"left\" value=\"${(requestScope.pageBean.pageSize-1)/2}\" maxFractionDigits=\"0\" pattern=\"#\"/>\n" +
            "\t\t<f:formatNumber var=\"right\" value=\"${(requestScope.pageBean.pageSize-1)/2+0.1}\" maxFractionDigits=\"0\" pattern=\"#\"/>\n" +
            "\t\t\n" +
            "      <c:set var=\"begin\" value=\"1\"/>\n" +
            "      <c:set var=\"end\" value=\"${requestScope.pageBean.totalPage}\"/>\n" +
            "\n" +
            "      <c:if test=\"${requestScope.pageBean.currentPage>right}\">\n" +
            "\t\t  <c:set var=\"begin\" value=\"${requestScope.pageBean.currentPage - right}\"/>\n" +
            "\t  </c:if>\n" +
            "      <c:if test=\"${requestScope.pageBean.currentPage < (requestScope.pageBean.totalPage - left)}\">\n" +
            "\t\t  <c:set var=\"end\" value=\"${requestScope.pageBean.currentPage+left}\"/>\n" +
            "\t  </c:if>\n" +
            "      <c:if test=\"${end<requestScope.pageBean.pageSize}\">\n" +
            "\t\t  <c:set var=\"end\" value=\"${requestScope.pageBean.pageSize}\"/>\n" +
            "\t  </c:if>\n" +
            "      <c:if test=\"${begin>(end-requestScope.pageBean.pageSize+1)}\">\n" +
            "\t\t  <c:set var=\"begin\" value=\"${end-requestScope.pageBean.pageSize+1}\"/>\n" +
            "\t  </c:if>\n" +
            "      <c:if test=\"${end>requestScope.pageBean.totalPage}\">\n" +
            "\t\t  <c:set var=\"end\" value=\"${requestScope.pageBean.totalPage}\"/>\n" +
            "\t  </c:if>\n" +
            "\n" +
            "        \t<a href=\"courseTypeAction_findAllByPage.action?pc=1${requestScope.pageBean.param}\">[首页]</a>\n" +
            "\n" +
            "      <c:if test=\"${requestScope.pageBean.currentPage > 1}\">\n" +
            "        <a href=\"courseTypeAction_findAllByPage.action?pc=${requestScope.pageBean.currentPage - 1}${requestScope.pageBean.param}\">上一页</a>\n" +
            "      </c:if>\n" +
            "      <c:forEach end=\"${end}\" begin=\"${begin}\" var=\"v\">\n" +
            "\n" +
            "        <a href=\"courseTypeAction_findAllByPage.action?pc=${v}${requestScope.pageBean.param}\">\n" +
            "          <c:if test=\"${requestScope.pageBean.currentPage eq v}\">\n" +
            "\t\t\t  ${v}\n" +
            "\t\t  </c:if>\n" +
            "          <c:if test=\"${requestScope.pageBean.currentPage != v}\">\n" +
            "\t\t\t  [${v}]\n" +
            "\t\t  </c:if>\n" +
            "        </a>\n" +
            "      </c:forEach>\n" +
            "      <c:if test=\"${requestScope.pageBean.currentPage < requestScope.pageBean.totalPage}\">\n" +
            "        <a href=\"courseTypeAction_findAllByPage.action?pc=${requestScope.pageBean.currentPage + 1}${requestScope.pageBean.param}\">下一页</a>\n" +
            "      </c:if>\n" +
            " </c:if>\n" +
            "            <a href=\"courseTypeAction_findAllByPage.action?pc=${requestScope.pageBean.totalPage}${requestScope.pageBean.param}\">[尾页]</a>\n" +
            "        </span>\n" +
            "    </td>\n" +
            "  </tr>\n" +
            "</table>";


//  <table border="0" cellspacing="0" cellpadding="0" align="center">
//  <tr>
//    <td align="right">
//    	<span>第${requestScope.pageBean.currentPage}/${requestScope.pageBean.totalPage}页</span>
//        <span>
//			<c:set var="pageBean" value="${requestScope.pageBean}"/>
//    <c:if test="${pageBean!=null}">
//
//		<f:formatNumber var="left" value="${(requestScope.pageBean.pageSize-1)/2}" maxFractionDigits="0" pattern="#"/>
//		<f:formatNumber var="right" value="${(requestScope.pageBean.pageSize-1)/2+0.1}" maxFractionDigits="0" pattern="#"/>
//
//      <c:set var="begin" value="1"/>
//      <c:set var="end" value="${requestScope.pageBean.totalPage}"/>
//
//      <c:if test="${requestScope.pageBean.currentPage>right}">
//		  <c:set var="begin" value="${requestScope.pageBean.currentPage - right}"/>
//	  </c:if>
//      <c:if test="${requestScope.pageBean.currentPage < (requestScope.pageBean.totalPage - left)}">
//		  <c:set var="end" value="${requestScope.pageBean.currentPage+left}"/>
//	  </c:if>
//      <c:if test="${end<requestScope.pageBean.pageSize}">
//		  <c:set var="end" value="${requestScope.pageBean.pageSize}"/>
//	  </c:if>
//      <c:if test="${begin>(end-requestScope.pageBean.pageSize+1)}">
//		  <c:set var="begin" value="${end-requestScope.pageBean.pageSize+1}"/>
//	  </c:if>
//      <c:if test="${end>requestScope.pageBean.totalPage}">
//		  <c:set var="end" value="${requestScope.pageBean.totalPage}"/>
//	  </c:if>
//
//        	<a href="courseTypeAction_findAllByPage.action?pc=1${requestScope.pageBean.param}">[首页]</a>
//
//      <c:if test="${requestScope.pageBean.currentPage > 1}">
//        <a href="courseTypeAction_findAllByPage.action?pc=${requestScope.pageBean.currentPage - 1}${requestScope.pageBean.param}">上一页</a>
//      </c:if>
//      <c:forEach end="${end}" begin="${begin}" var="v">
//
//        <a href="courseTypeAction_findAllByPage.action?pc=${v}${requestScope.pageBean.param}">
//          <c:if test="${requestScope.pageBean.currentPage eq v}">
//    ${v}
//		  </c:if>
//          <c:if test="${requestScope.pageBean.currentPage != v}">
//            [${v}]
//		  </c:if>
//        </a>
//      </c:forEach>
//      <c:if test="${requestScope.pageBean.currentPage < requestScope.pageBean.totalPage}">
//        <a href="courseTypeAction_findAllByPage.action?pc=${requestScope.pageBean.currentPage + 1}${requestScope.pageBean.param}">下一页</a>
//      </c:if>
// </c:if>
//            <a href="courseTypeAction_findAllByPage.action?pc=${requestScope.pageBean.totalPage}${requestScope.pageBean.param}">[尾页]</a>
//        </span>
//    </td>
//  </tr>
//</table>";


    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    public PageBean() {
    }

    public PageBean(int currentPage, List<T> lists, int totalPage, int pageSize, int pageCount, String param) {
        this.currentPage = currentPage;
        this.lists = lists;
        this.totalPage = totalPage;
        this.pageSize = pageSize;
        this.param = param;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "currentPage=" + currentPage +
                ", lists" + lists +
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

    public List<T> getLists() {
        return lists;
    }

    public void setLists(List<T> books) {
        this.lists = books;
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

    public String getHtml() {
        return html;
    }
}
