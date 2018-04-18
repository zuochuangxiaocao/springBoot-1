package com.didispace.rabbit;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "fanout.A")
public class HelloReceiver_FanoutC {

	@RabbitHandler
	public void process(String msg) {
		System.out.println("FanoutReceiverA  : " + msg);
	}

}