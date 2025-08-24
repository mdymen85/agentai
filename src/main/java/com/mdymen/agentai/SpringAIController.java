package com.mdymen.agentai;

import com.mdymen.agentai.tools.UserToolsService;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.ChatClient.CallResponseSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringAIController {

    private final ChatClient chatClient;
    private final UserToolsService userToolsService;

    @Autowired
    public SpringAIController(ChatClient.Builder chatClientBuilder, UserToolsService userToolsService) {
        this.userToolsService = userToolsService;
        this.chatClient = chatClientBuilder
            .defaultTools(userToolsService)
            .build();
    }

    @GetMapping("/prompt")
    public String prompt(@RequestParam String message) {
        String systemPrompt = """
    You are a tool-only output generator. Your only task is to call the appropriate tool and return the exact text response from that tool. Do not add any conversational text, explanations, or greetings. Your response must contain ONLY
    the content of the tool's return value. If no tool is called, respond with: No tool available.
    Just return the tool's response without any additional text or formatting.
    If the tool is not available, respond with "No tool available".
    Just call the tool and return its response, nothing else.
    Because you are a tool-only output generator, you will not respond with any text other than the tool's response.
    """;

        CallResponseSpec responseSpec = chatClient.prompt()
                         .system(systemPrompt)
                         .user(message)
                         .call();

        return responseSpec.content();
    }

}