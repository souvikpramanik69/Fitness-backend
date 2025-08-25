package com.fitness.activityservice.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class RabbitmqConfig {


//    @Value("${rabbitmq.queue.name}")
//    private String queue;
//
//    @Bean
//    public Queue activityQueue(){
//         return new Queue(queue,true);
//    }
//
//    @Bean
//    public MessageConverter jsonMessageConverter(){
//       return new Jackson2JsonMessageConverter();
//    }

}
