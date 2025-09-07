package com.aiapp.chatbot;

import dev.langchain4j.model.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAiConfig {

    // ✅ Load API key from application.properties or environment
    @Value("${openai.api.key:}")
    private String apiKey;

    @Bean
    public OpenAiChatModel chatModel() {
        if (apiKey == null || apiKey.isEmpty()) {
            throw new IllegalStateException(
                    "❌ OPENAI_API_KEY is missing! Please set it in application.properties or environment variable."
            );
        }

        return OpenAiChatModel.builder()
                .apiKey(apiKey)
                .modelName("gpt-4o-mini")
                .build();
    }
}
