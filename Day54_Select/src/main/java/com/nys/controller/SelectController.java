package com.nys.controller;

import com.nys.domain.NumWrap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Controller
public class SelectController {
    private String[] num={"11","1198","141","13541"
            ,"2265","2092","262","38","36","44"};
    @RequestMapping("/show/{index}")
    @ResponseBody
    public NumWrap getNumByIndex(@PathVariable String index){
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < num.length; i++) {
            if (num[i].charAt(0)==index.charAt(0)){
                list.add(num[i]);
            }
        }
//        System.out.println(Arrays.toString(list.toArray()));
        NumWrap numWrap = new NumWrap(200,"success",list);
        return numWrap;
    }
    @RequestMapping("/upload")
    public String uploadFile(MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        if(file!=null&&fileName!=null&&fileName.length()>0){
            String path = "C:\\upload";
            String newFileName = UUID.randomUUID()+fileName.substring(fileName.lastIndexOf("."));
            File newFile = new File(path,newFileName);
            file.transferTo(newFile);
        }
        return "success";
    }
}
