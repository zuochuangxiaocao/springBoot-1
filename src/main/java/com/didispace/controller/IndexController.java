package com.didispace.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.didispace.exception.MyException;

@Controller
public class IndexController {

	@RequestMapping("index")
    public String index(ModelMap map) {
        map.addAttribute("host", "http://blog.didispace.com");
        return "index";
    }
	
	@RequestMapping("/error/html")
    public String hello() throws Exception {
        throw new Exception("发生错误");
    }

    @RequestMapping("/error/json")
    public String json() throws MyException {
        throw new MyException("发生错误2");
    }
	
}
