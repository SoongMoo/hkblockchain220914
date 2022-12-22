package com.example.springBootTest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {
	@RequestMapping("/")
	public String test() {
		return "파일 없이 문자열 출력";
	}
}