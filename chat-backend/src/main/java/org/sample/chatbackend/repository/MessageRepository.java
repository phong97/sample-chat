package org.sample.chatbackend.repository;

import org.sample.chatbackend.model.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author phonghv
 */
public interface MessageRepository extends JpaRepository<Message, Long> {
}
