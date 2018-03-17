package com.lanou.springbootbase;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@ComponentScan("com.lanou")
public class SpringbootbaseApplication {

	@Value("${project.author}")
	private String projectAuthor;

	@Value("${project.name}")
	private String projectName;

	@RequestMapping("/")
	public String index(){
		return "projectAuthor:---"+projectAuthor+"	projectName:---"+projectName;
	}

	public static void main(String[] args) {
		//启动SpringBoot项目
//		SpringApplication.run(SpringbootbaseApplication.class, args);

		//关闭banner
//		SpringApplication app = new SpringApplication(SpringbootbaseApplication.class);
//		app.setBannerMode(Banner.Mode.OFF);
//		app.run(args);
	}


}
