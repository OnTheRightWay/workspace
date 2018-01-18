import com.zhuang.util.VerifyCode;
import org.junit.Test;

public class T {
    @Test
    public void t(){
        String output = VerifyCode.getInstance().output("C:\\Users\\lanou3g\\Desktop\\随便建的文件夹/show.jpg");
        System.out.println(output);
    }
}
