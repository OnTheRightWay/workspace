package user.web;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Result;
import com.zhuang.util.VerifyCode;
import org.apache.struts2.ServletActionContext;

import java.io.IOException;

public class CodeImgAction extends ActionSupport {
    public String codeImg() throws IOException {
       return SUCCESS;
    }
}
