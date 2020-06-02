package com.er.amqp.impl;

import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.er.amqp.AmqpConsumer;
import com.er.dto.Message;
import com.er.services.ConsumerService;

@Component
public class RabbitMQConsumer implements AmqpConsumer<Message>{

	@Autowired
	private ConsumerService consumerService;
	
	@Override
	@RabbitListener(queues = "${spring.rabbitmq.request.routing-key.producer}")
	public void consume(Message message) {
		try {
			consumerService.action(message);
		} catch(Exception e) {
			throw new AmqpRejectAndDontRequeueException(e);
		}
	}

}
