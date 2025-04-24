package org.sample.chatbackend.model.dto;

import org.sample.chatbackend.model.entity.Message;

import java.time.LocalDateTime;

/**
 * @author phonghv
 */
public class MessageDto {
    private Long id;
    private String sender;
    private String content;
    private LocalDateTime timestamp;

    public MessageDto() {}

    public MessageDto(Long id, String sender, String content, LocalDateTime timestamp) {
        this.id = id;
        this.sender = sender;
        this.content = content;
        this.timestamp = timestamp;
    }

    public MessageDto(Message message) {
        this.id = message.getId();
        this.sender = message.getSender();
        this.content = message.getContent();
        this.timestamp = message.getTimestamp();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Message toEntity() {
        Message message = new Message(sender, content, timestamp);
        message.setId(id);
        return message;
    }
}
