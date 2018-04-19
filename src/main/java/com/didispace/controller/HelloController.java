package com.didispace.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@Value("${com.didispace.name}")
	private String name;
	@Value("${com.didispace.title}")
	private String title;
	@Value("${com.didispace.desc}")
	private String desc;
	
    @RequestMapping("/hello")
    public String index() {
    	
    	System.out.println("name=============="+name+name);
    	
    	System.out.println("title=============="+title);
    	
    	System.out.println("desc=============="+desc);
    	
        return "Hello World";
    }

}