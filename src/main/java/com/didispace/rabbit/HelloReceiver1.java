package com.didispace.rabbit;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.didispace.model.MemberLogin;

@Component
@RabbitListener(queues = "hello")
public class HelloReceiver1 {

    @RabbitHandler
    public void process(MemberLogin l) {
        System.out.println("Receiver 1 : " + "area=====" +l.getArea() + "       i=" + l.getId());
    }

}