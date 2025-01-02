package com.shraddha.chatbot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ChatbotController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, welcome haahaaa to the Chatbot API!";
    }

    @GetMapping("/chat")
    public String chat(@RequestParam String message) {
        // For now, return a basic response. You can expand this later.
        return "You said: " + message;
    }
}

