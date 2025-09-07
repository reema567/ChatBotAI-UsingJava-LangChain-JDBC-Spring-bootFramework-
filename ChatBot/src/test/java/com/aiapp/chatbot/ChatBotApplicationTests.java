package com.aiapp.chatbot;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = ChatBotApplication.class)
class ChatBotApplicationTests {

	@Test
	void contextLoads() {
		// ✅ Simple smoke test to check context loads
		System.out.println("Spring Boot Context Loaded Successfully 🚀");
	}
}
