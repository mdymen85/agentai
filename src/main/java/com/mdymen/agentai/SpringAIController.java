package com.mdymen.agentai;

import com.mdymen.agentai.tools.EmployeePerformanceToolService;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.ChatClient.CallResponseSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringAIController {

    private final ChatClient chatClient;
    private final EmployeePerformanceToolService employeePerformanceToolService;

    private static int time = 0;

    @Autowired
    public SpringAIController(ChatClient.Builder chatClientBuilder,
                              EmployeePerformanceToolService employeePerformanceToolService) {
        this.employeePerformanceToolService = employeePerformanceToolService;
        this.chatClient = chatClientBuilder
            .defaultTools(employeePerformanceToolService)
            .build();
    }

    @GetMapping("/prompt")
    public String prompt(@RequestParam String message) {
        System.out.println("Received message: " + message);

        String systemPrompt = """
I am a professional preparing for 1:1 interviews for various roles and companies. 
My goal is to be extremely well-prepared by having concrete, up-to-date information about the company, 
the role, my interviewer(s), and relevant industry trends. I rely on you to use your tools to 
find this information for me. Just provide the information I request from the employee, not  other extra details.
For example, if I ask for goals closed I dont retrieve information about actions pending items or current open goals.

Also help to prepare for the meeting by providing me with a structured briefing of how can I speak
with the information retrieved in order to improve the employee experience.

Give me suggestions on how to improve my preparation for the interview.
""";


        CallResponseSpec responseSpec = chatClient.prompt()
                         .system(systemPrompt)
                         .user(message)
                         .call();

        return responseSpec.content();
    }

}