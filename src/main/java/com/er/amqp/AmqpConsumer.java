package com.er.amqp;

public interface AmqpConsumer<T> {
	
	void consume(T t);
}
