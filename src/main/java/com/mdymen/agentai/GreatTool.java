package com.mdymen.agentai;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Component;

@Component
public class GreatTool {

    /**
     *  This method will be called by the AI model to a greet a user.
     *
     * @param name
     * @return
     */
    @Tool(name = "greetUser", description = "Returns a greet message for someone that is joining")
    public String greetUser(String name) {
        return "Hello, " + name + "! Chavo del Ocho";
    }

    /**
     * This method will be called by the AI model to say goodbye to a user.
     *
     * @param name
     * @return
     */
    @Tool(name = "goodbyeUser", description = "Returns a goodbye message for someone that is leaving")
    public String goodbyeUser(String name) {
        return "good bye, " + name + ", see you next time ! Chapulin Colorado";
    }

}
