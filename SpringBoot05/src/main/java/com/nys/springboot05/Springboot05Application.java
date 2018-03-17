package com.nys.springboot05;

import com.nys.spring_boot_starter_demo.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@ComponentScan("com.nys")
@RestController
public class Springboot05Application {

	@Autowired
	DemoService demoService;

	@RequestMapping("/")
	public String index(){
		return demoService.say();
	}
	public static void main(String[] args) {
		SpringApplication.run(Springboot05Application.class, args);
	}
}
