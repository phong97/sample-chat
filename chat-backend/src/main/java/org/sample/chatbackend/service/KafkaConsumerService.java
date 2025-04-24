package org.sample.chatbackend.service;

import org.sample.chatbackend.model.entity.Message;
import org.sample.chatbackend.repository.MessageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class KafkaConsumerService {
    private static final Logger logger = LoggerFactory.getLogger(KafkaConsumerService.class);

    private final MessageRepository messageRepository;

    public KafkaConsumerService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @KafkaListener(topics = "chat-topic", groupId = "chat-group")
    public void listen(String message) {
        logger.info("Received message: {}", message);

        try {
            // Parse the message (format: "sender:content")
            String[] parts = message.split(":", 2);
            if (parts.length == 2) {
                String sender = parts[0];
                String content = parts[1];

                // Create message entity
                Message messageEntity = new Message();
                messageEntity.setSender(sender);
                messageEntity.setContent(content);
                messageEntity.setTimestamp(LocalDateTime.now());

                // Save to database
                messageRepository.save(messageEntity);
                logger.info("Message saved to database");
            } else {
                logger.error("Invalid message format: {}", message);
            }
        } catch (Exception e) {
            logger.error("Error processing message: {}", e.getMessage(), e);
        }
    }
}