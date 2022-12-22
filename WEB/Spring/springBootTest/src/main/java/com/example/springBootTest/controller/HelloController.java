package com.example.springBootTest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	@RequestMapping(value = "hello")
	public String hello() {
		//return "hello/hello"; // jsp
		return "thymeleaf/hello/testHello";
	}
}
