package action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.lang3.StringUtils;

public class SingleValAction extends ActionSupport {
    private String single;

    public String single(){
        return SUCCESS;
    }

    //定义一个方法
    //命名方式为：validate+要验证的方法名
    //这个方法会由struts2帮我们调用
    //只会验证single方法
    public void validateSingle(){
        if (StringUtils.isBlank(single)){
            //只要添加了错误信息
            //那么就会将结果视图改成input
            addFieldError("errorMsg","single不能为空");
        }
    }

    public String getSingle() {
        return single;
    }

    public void setSingle(String single) {
        this.single = single;
    }
}
