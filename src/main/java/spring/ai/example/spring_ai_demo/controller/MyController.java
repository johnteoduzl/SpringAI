package spring.ai.example.spring_ai_demo.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class MyController {

private final ChatClient openAiChatClient;

public MyController(ChatClient.Builder openAiChatClient) {
    this.openAiChatClient = openAiChatClient.build();
}

@GetMapping("/chat")
    public String chat(@RequestParam("message") String message) {
    return openAiChatClient.prompt(message).call().content();
}

}
