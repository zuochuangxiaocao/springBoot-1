package com.didispace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.didispace.rabbit.HelloSender;
import com.didispace.rabbit.HelloSender_Fanout;

@RestController
public class RabbitController {
	
	@Autowired
	private HelloSender helloSender;
	
	@Autowired
	private HelloSender_Fanout helloSender_Fanout;
	
	@RequestMapping("/r1")
    public void r1() {
		for (int i=0;i<100;i++){
			helloSender.send(i);
		}
	}
	
	@RequestMapping("/r2")
    public void r2() {
		helloSender_Fanout.send();
	}
	
}
