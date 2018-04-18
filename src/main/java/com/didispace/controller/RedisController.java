package com.didispace.controller;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.didispace.model.MemberLogin;

@RestController
public class RedisController {

	@Autowired
    private StringRedisTemplate stringRedisTemplate;
    
	@Autowired
	private RedisTemplate redisTemplate;
	
	@RequestMapping("/redis")
    public String redis() {
		stringRedisTemplate.opsForValue().set("aaa:aaa", "111");
		
		MemberLogin memberLogin = new MemberLogin();
		 ValueOperations<String, MemberLogin> operations=redisTemplate.opsForValue();
	     operations.set("com.neox", memberLogin);
	     operations.set("com.neo.f", memberLogin,60,TimeUnit.SECONDS);
	     
	     
	    System.out.println("--------------"+redisTemplate.opsForValue().get("com.neox"));
	     
	     
		return "ss";
	}
	
}
