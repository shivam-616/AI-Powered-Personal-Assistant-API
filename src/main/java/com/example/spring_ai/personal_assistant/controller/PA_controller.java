package com.example.spring_ai.personal_assistant.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.SystemPromptTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/ai")
public class PA_controller {
    private final ChatClient chatClient;

    public PA_controller(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @GetMapping("/chat")
    public String chat(@RequestParam String question){
        return chatClient.prompt().user(question).call().content();
    }
    @GetMapping("/ask")
    public String ask(@RequestParam String question  ,  @RequestParam String persona) {
        String blueprint = " play a persona of {persona}";
        SystemPromptTemplate systemPromptTemplate = new SystemPromptTemplate(blueprint);

        Message sysmessage = systemPromptTemplate.createMessage(Map.of("persona",persona));
        Message usermessage = new UserMessage(question);

        Prompt prompt = new Prompt(sysmessage,usermessage);

        return chatClient.prompt(prompt).call().content();



    }
}