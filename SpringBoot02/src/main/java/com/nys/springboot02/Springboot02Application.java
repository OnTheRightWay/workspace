package com.nys.springboot02;

import com.nys.config.AuthorSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@ComponentScan("com.nys")
public class Springboot02Application {

	@Autowired
	private AuthorSettings authorSettings;

	@RequestMapping("/")
	public String index(){
		return "author name is:---"+authorSettings.getName()+"	author gender is:---"+authorSettings.getGender();
	}

	public static void main(String[] args) {
		//启动SpringBoot项目
		SpringApplication.run(Springboot02Application.class, args);

		//关闭banner
//		SpringApplication app = new SpringApplication(Springboot02Application.class);
//		app.setBannerMode(Banner.Mode.OFF);
//		app.run(args);
	}
}
