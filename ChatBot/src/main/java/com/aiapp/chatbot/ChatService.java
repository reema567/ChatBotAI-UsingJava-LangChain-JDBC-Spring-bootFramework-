package com.aiapp.chatbot;

import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.model.output.Response;
import dev.langchain4j.model.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ChatService {

    private final OpenAiChatModel chatModel;

    // ✅ Option A: Inject API key from application.properties
    public ChatService(@Value("${openai.api.key}") String openAiApiKey) {
        if (openAiApiKey == null || openAiApiKey.isBlank()) {
            throw new IllegalArgumentException("OpenAI API key is missing! Please set openai.api.key in application.properties");
        }

        this.chatModel = OpenAiChatModel.builder()
                .apiKey(openAiApiKey)
                .modelName("gpt-4o-mini")
                .build();
    }

    public String chat(String userMessage) {
        Response<AiMessage> response = chatModel.generate(List.of(UserMessage.from(userMessage)));
        return response.content().text();
    }
}
