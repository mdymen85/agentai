package com.mdymen.agentai.tools;

import com.mdymen.agentai.dto.UserDTO;
import com.mdymen.agentai.entity.User;
import com.mdymen.agentai.repository.UserRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class UserToolsService {

    private final UserRepository userRepository;

    @Tool(name = "secretKey", description = "Returns the secret key for a given user name", returnDirect = true)
    public String secretKey(String name) {
        log.info("Fetching secret key for user: {}", name);
        String secret = userRepository.findByName(name)
            .orElseThrow(() -> new RuntimeException("User not found")).getSecretKey();
        log.info("Found secret key for user {}: {}", name, secret);
        return secret;
    }

    @Tool(name = "users", description = "Return the lists of users", returnDirect = true)
    public List<UserDTO> users() {
        log.info("Fetching all users");
        return userRepository.findAll()
            .stream()
            .map(user -> UserDTO.builder()
                                .name(user.getName())
                                .email(user.getEmail())
                                .build())
            .toList();
    }
}
