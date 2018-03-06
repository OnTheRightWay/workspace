package com.nys.crm.post.web.action;

import com.nys.crm.department.domain.Department;
import com.nys.crm.department.service.DepartmentService;
import com.nys.crm.post.domain.Post;
import com.nys.crm.post.service.PostService;
import com.nys.paging.PagingUtil;
import com.nys.paging.bean.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import org.apache.struts2.interceptor.ServletRequestAware;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Set;

public class PostAction extends ActionSupport implements ModelDriven<Post>,ServletRequestAware{
    private PostService postService;
    private DepartmentService departmentService;
    private HttpServletRequest request;
    private Post post;
    private int pc;
    private PageBean<List<Post>> pageBean;

    public String findPostByDepId(){
        Set<Post> posts = postService.findPostByDepId(post.getDepId());
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.setExcludes(new String[]{"department","staffs"});
        JSONArray jsonArray = JSONArray.fromObject(posts,jsonConfig);
        ActionContext.getContext().put("json",jsonArray);
        return "write";
    }
    public String findAllByPage(){
        int size = 10;
        int begin=(pc-1)*size;
        pageBean.setPageSize(size);
        List<Post> posts = postService.findAllByPage(begin,size);
        int count = postService.findCount();
        PageBean pageBean = PagingUtil.getPageBean(this.pageBean,posts,pc,count,null,null);
        request.setAttribute("pageBean",pageBean);
        return "listPost";
    }

    public String addOrEditPost(){
        if (post.getPostName()==null||post.getDepartment().getDepId()==null){
            return "findAllByPage";
        }

        if (post.getPostId()==null||post.getPostId().equals("")){
            postService.addPost(post);

            return "findAllByPage";
        }
        postService.updatePost(post);

        return "findAllByPage";
    }

    public String toEdit(){
        List<Department> departments = departmentService.findAll();
        ActionContext.getContext().put("departments",departments);
        Post post = postService.findPostById(this.post.getPostId());
        ActionContext.getContext().put("post",post);
        return "addOrEditPost";
    }

    public int getPc() {
        return pc;
    }

    public void setPc(int pc) {
        this.pc = pc;
    }

    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public void setPageBean(PageBean<List<Post>> pageBean) {
        this.pageBean = pageBean;
    }

    public void setPostService(PostService postService) {
        this.postService = postService;
    }

    @Override
    public Post getModel() {
        return post;
    }

    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {
        request = httpServletRequest;
    }
}
