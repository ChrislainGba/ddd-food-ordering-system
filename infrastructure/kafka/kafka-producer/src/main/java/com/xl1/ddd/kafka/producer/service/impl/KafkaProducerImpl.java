package com.xl1.ddd.kafka.producer.service.impl;

import java.io.Serializable;
import java.util.concurrent.CompletableFuture;

import org.apache.avro.specific.SpecificRecordBase;
import org.springframework.kafka.KafkaException;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.xl1.ddd.kafka.producer.exception.KafkaProducerException;
import com.xl1.ddd.kafka.producer.service.KafkaProducer;

import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class KafkaProducerImpl<K extends Serializable, V extends SpecificRecordBase> implements KafkaProducer<K, V> {

    private final KafkaTemplate<K, V> kafkaTemplate;

    public KafkaProducerImpl(KafkaTemplate<K, V> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

 
    
    @Override
	public void send(String topicName, K key, V message) {
    	log.info("Sending message={} to topic={}", message, topicName);
        CompletableFuture<SendResult<K, V>> completableFuture = new CompletableFuture<>();
        try {
        	kafkaTemplate.send(topicName, key, message)
            .whenComplete((sendResult, exception) -> {
                if (exception != null) {
                	log.error("Error on kafka producer with key: {}, message: {} and exception: {}", key, exception.getMessage());
                    completableFuture.completeExceptionally(exception);
                } else {
                    completableFuture.complete(sendResult);
                }
            });
        } catch (KafkaException e) {
        	log.error("Error on kafka producer with key: {}, message: {} and exception: {}", key, message,
                    e.getMessage());
            throw new KafkaProducerException("Error on kafka producer with key: " + key + " and message: " + message);
        }
	}
    

    @PreDestroy
    public void close() {
        if (kafkaTemplate != null) {
            log.info("Closing kafka producer!");
            kafkaTemplate.destroy();
        }
    }

	

	
}

