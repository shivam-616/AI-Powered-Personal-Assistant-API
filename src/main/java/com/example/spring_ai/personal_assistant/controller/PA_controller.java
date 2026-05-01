package com.example.spring_ai.personal_assistant.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ai")
public class PA_controller {
    private final ChatClient chatClient;

    public PA_controller(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

        @GetMapping("/chat")
        public String chat(@RequestParam String question) {
        return chatClient.prompt().user(question).call().content();
        }
}