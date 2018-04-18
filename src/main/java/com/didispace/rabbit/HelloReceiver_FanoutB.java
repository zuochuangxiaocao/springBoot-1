package com.didispace.rabbit;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "fanout.B")
public class HelloReceiver_FanoutB {

	@RabbitHandler
	public void process(String msg) {
		System.out.println("FanoutReceiverB  : " + msg);
	}

}