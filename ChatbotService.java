package com.shraddha.chatbot.service;

import com.shraddha.chatbot.model.Message;
import com.shraddha.chatbot.repository.MessageRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ChatbotService {

    private final MessageRepository messageRepository;

   
    public ChatbotService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public String getResponse(String messageContent) {
        saveMessage("User", messageContent); 
        String response = generateResponse(messageContent);
        saveMessage("Bot", response);
        return response;
    }

    private void saveMessage(String sender, String content) {
        Message message = new Message();
        message.setSender(sender);
        message.setContent(content);
        message.setTimestamp(LocalDateTime.now());
        messageRepository.save(message);
    }

    private String generateResponse(String messageContent) {
        if (messageContent.toLowerCase().contains("hello")) {
            return "Hello! How can I help you?";
        } else if (messageContent.toLowerCase().contains("bye")) {
            return "Goodbye! Have a great day!";
        }
        return "I'm here to assist you.";
    }
}
