package com.shraddha.chatbot.repository;

import com.shraddha.chatbot.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    // You can add custom query methods here if needed
}
