package com.mdymen.agentai.tools;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.mdymen.agentai.entity.User;
import com.mdymen.agentai.entity.UserValues;
import com.mdymen.agentai.entity.Values;
import com.mdymen.agentai.repository.UserRepository;
import com.mdymen.agentai.repository.UsersValuesRepository;
import com.mdymen.agentai.repository.ValuesRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.core.SdkBytes;
import software.amazon.awssdk.services.bedrockruntime.BedrockRuntimeClient;
import software.amazon.awssdk.services.bedrockruntime.model.InvokeModelRequest;
import software.amazon.awssdk.services.bedrockruntime.model.InvokeModelResponse;

@Component
@RequiredArgsConstructor
@Slf4j
public class UserToolsService {

    private final UserRepository userRepository;
    private final ValuesRepository valuesRepository;
    private final UsersValuesRepository usersValuesRepository;

    private static final String MODEL = "us.anthropic.claude-3-7-sonnet-20250219-v1:0";

    @Autowired
    private BedrockRuntimeClient bedrockRuntimeClient;

    public String syncResponse(String enclosePrompt) {

        String payload = new JSONPObject("messages", List.of(
            new JSONPObject("prompt", "tell me a joke"),
            new JSONPObject("content", enclosePrompt)
        )).toString();

        InvokeModelRequest request = InvokeModelRequest.builder().body(SdkBytes.fromUtf8String(payload))
                                                   .modelId(MODEL).contentType("application/json").accept("application/json").build();
        InvokeModelResponse response = bedrockRuntimeClient.invokeModel(request);

        log.info("Response: {}", response.body().asUtf8String());
        return response.body().asUtf8String();
    }

    @Tool(name = "user", description = "Return the information of user")
    public User getUser(String name) {
        log.info("Fetching user info for: {}", name);
        User user = userRepository.findByFirstName(name)
            .orElse(new User());
        log.info("Found user: {}", user);
        return user;
    }

    @Tool(name = "values", description = "Return the list of values")
    public List<Values> getValueList() {
        log.info("Fetching all values");
        List<Values> values = valuesRepository.findAll();
        log.info("Found {} values", values.size());
        return values;
    }

    @Tool(name = "valueByName", description = "Return the value by its name")
    public Values getValueByName(String valueName) {
        log.info("Fetching value for: {}", valueName);
        Values value = valuesRepository.findAll().stream()
            .filter(v -> v.getValueName().equalsIgnoreCase(valueName))
            .findFirst().orElse(null);
        log.info("Found value: {}", value);
        return value;
    }

    @Tool(name = "valueById", description = "Return the value by its ID")
    public Values getValueById(String valueId) {
        log.info("Fetching value for ID: {}", valueId);
        Values value = valuesRepository.findById(valueId).orElse(null);
        log.info("Found value: {}", value);
        return value;
    }

    @Tool(name = "valuesByUser", description = "Return the values from a specific users by userId")
    public List<Values> getValuesByUser(String userId) {
        log.info("Fetching values for user ID: {}", userId);
        List<UserValues> userValues = usersValuesRepository.findByUserId(userId);
        log.info("Found {} user values", userValues.size());
        List<Values> values = userValues.stream()
            .map(uv -> valuesRepository.findById(uv.getUserId()).orElse(null))
            .toList();
        log.info("Mapped to {} values", values.size());
        return values;
    }


//    @Tool(name = "email", description = "Return the email of the given user")
//    public String email(String user) {
//        log.info("Fetching all user emails");
//        return userRepository.findByName(user)
//            .orElse(new User())
//            .getEmail();
//    }

//    @Tool(name = "secretKey", description = "Returns the secret key for a given user name")
//    public String secretKey(String name) {
//        log.info("Fetching secret key for user: {}", name);
//        String secret = userRepository.findByName(name)
//            .orElse(new User()).getSecretKey();
//        log.info("Found secret key for user {}: {}", name, secret);
//        return secret;
//    }
//
//    @Tool(name = "users", description = "Return the lists of users")
//    public String users() {
//        log.info("Fetching all users");
//        return userRepository.findAll()
//            .stream()
//            .map(user -> UserDTO.builder()
//                                .name(user.getName())
//                                .email(user.getEmail())
//                                .build())
//            .toList()
//            .stream()
//            .map(UserDTO::toString)
//            .reduce((a, b) -> a + "\n" + b)
//            .orElse("No users found");
//    }
}
