package org.sample.chatbackend.service;

import org.sample.chatbackend.model.dto.MessageDto;
import org.sample.chatbackend.repository.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author phonghv
 */
@Service
public class MessageService {

    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public List<MessageDto> getAllMessages() {
        return messageRepository.findAll().stream()
                .map(MessageDto::new)
                .toList();
    }
}
