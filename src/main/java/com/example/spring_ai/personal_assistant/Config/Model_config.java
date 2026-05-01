package com.example.spring_ai.personal_assistant.Config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Model_config {
    @Bean
    public ChatClient chatClient(ChatClient.Builder chatClient){
        return chatClient.build();
    }

}
