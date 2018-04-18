package com.didispace.rabbit;

import java.util.Date;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.didispace.model.MemberLogin;

@Component
public class HelloSender {

	@Autowired
	private AmqpTemplate rabbitTemplate;

	public void send(int i) {
		String context = "hello " + new Date() + "---------" + i;
		System.out.println("Sender : " + context);
		MemberLogin l = new MemberLogin();
		l.setArea(context);
		l.setId(i);
		this.rabbitTemplate.convertAndSend("hello", l);
	}

}