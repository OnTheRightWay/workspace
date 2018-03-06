import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@WebServlet(name = "FileServlet",urlPatterns = "/file")
public class FileServlet extends BaseServlet {
    public String upload(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String savePath =
                request.getServletContext().getRealPath("/files");
        File file = new File(savePath);
        if (!file.isDirectory()||!file.exists()){
            file.mkdir();
        }

        DiskFileItemFactory factory =
                new DiskFileItemFactory();

        ServletFileUpload upload =
                new ServletFileUpload(factory);

        upload.setHeaderEncoding("UTF-8");

        upload.setSizeMax(1024*1024*10);
        upload.setFileSizeMax(1024*1024);


        //判断上传的文件
        if (!ServletFileUpload.isMultipartContent(request)){
            return "f:index.jsp";
        }
        List<FileItem> fileItems = null;

        try {
            fileItems = upload.parseRequest(request);
        } catch (FileUploadException e) {
            request.setAttribute("message","上传失败");
        }

        for (FileItem fileItem : fileItems) {
            if (!fileItem.isFormField()){
                continue;
            }
            String name = fileItem.getName();
            if (name == null||name.equals("")){
                continue;
            }
            String fileName =
                    name.substring(name.lastIndexOf("\\") + 1);
            InputStream is = fileItem.getInputStream();
            FileOutputStream fos =
                    new FileOutputStream(savePath+"\\"+fileName);
            byte[] buff = new byte[1024*1024*1024];
            int len = 0;
            while ((len = is.read(buff)) >0 ){
                fos.write(buff,0,len);
            }
            is.close();
            fos.close();

            fileItem.delete();
        }
        request.setAttribute("message","success");
        return "f:index.jsp";
    }
}
