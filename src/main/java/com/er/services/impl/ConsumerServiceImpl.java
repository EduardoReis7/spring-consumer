package com.er.services.impl;

import org.springframework.stereotype.Service;

import com.er.dto.Message;
import com.er.services.ConsumerService;

@Service
public class ConsumerServiceImpl implements ConsumerService{

	@Override
	public void action(Message message) throws Exception {
		System.out.println(message.getText());
	}

}
