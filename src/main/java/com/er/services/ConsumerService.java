package com.er.services;

import com.er.dto.Message;

public interface ConsumerService {
	
	void action(Message message) throws Exception;
}
