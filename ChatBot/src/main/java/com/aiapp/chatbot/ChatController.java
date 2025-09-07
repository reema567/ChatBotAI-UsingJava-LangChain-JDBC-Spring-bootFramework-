package com.aiapp.chatbot;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ChatController {

    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping
    //public ResponseEntity<String> chat(@RequestBody String message) {
      //  String response = chatService.getAIResponse(message);
      //  return ResponseEntity.ok(response);//
        //public String chat(@RequestBody String userMessage) {
        //    return chatService.chat(userMessage);
   // }
        @GetMapping("/health") public String health() {
        return "Application is running successfully!";
    }

    @GetMapping("/chat")
    public String chat(@RequestParam String message) {
        return "You said: " + message;
    }
}