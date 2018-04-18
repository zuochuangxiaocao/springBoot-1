package com.didispace.rabbit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Queue;

@Configuration
public class RabbitConfig1 {

    @Bean
    public Queue Queue() {
        return new Queue("hello");
    }

}