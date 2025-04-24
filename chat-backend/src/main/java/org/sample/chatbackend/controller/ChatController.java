package org.sample.chatbackend.controller;

import org.sample.chatbackend.model.dto.MessageDto;
import org.sample.chatbackend.service.KafkaProducerService;
import org.sample.chatbackend.service.MessageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author phonghv
 */
@RestController
@RequestMapping("/api")
public class ChatController {
    private final KafkaProducerService producerService;
    private final MessageService messageService;

    public ChatController(KafkaProducerService producerService, MessageService messageService) {
        this.producerService = producerService;
        this.messageService = messageService;
    }

    @PostMapping("/send")
    public void sendMessage(@RequestParam String sender, @RequestParam String content) {
        producerService.sendMessage("chat-topic", sender + ":" + content);
    }

    @GetMapping("/history")
    public List<MessageDto> getHistory() {
        return messageService.getAllMessages();
    }
}
