package com.mdymen.agentai;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.bedrockruntime.AmazonBedrockRuntime;
import com.amazonaws.services.bedrockruntime.AmazonBedrockRuntimeClient;
import com.amazonaws.services.bedrockruntime.model.InvokeModelRequest;
import com.amazonaws.services.bedrockruntime.model.InvokeModelResult;
import com.mdymen.agentai.tools.UserToolsService;
import com.mdymen.agentai.tools.VUserToolsService;
import com.mdymen.agentai.views.VUserCurrentRoleRequirements;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import software.amazon.awssdk.regions.Region;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class TestController {

    private final VUserToolsService vUserToolsService;
    private final UserToolsService userToolsService;


    @GetMapping
    private void testBedrock() {
        // Define our AWS region and keys
//        String regionName = "us-west-2";
//
//        // Create our credentials object for AWS security
//        BasicAWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);
//
//        // Get a handle to the Bedrock runtime client
//        AmazonBedrockRuntime bedrockRuntime = AmazonBedrockRuntimeClient.builder()
//                                                                        .withCredentials(new AWSStaticCredentialsProvider(credentials))
//                                                                        .withRegion(regionName)
//                                                                        .build();
//
//        // Define the promt we would like to send the AI
//        String prompt = "Describe the purpose of a 'hello world' program in one line.";
//
//        // Bedrock accepts a JSON object as it's request body.
//        JSONObject requestBody = new JSONObject(); //us.anthropic.claude-3-7-sonnet-20250219-v1:0
//        requestBody.put("anthropic_version", "bedrock-2023-05-31");
////        requestBody.put("anthropic_version", "us.anthropic.claude-3-7-sonnet-20250219-v1:0");
//        requestBody.put("max_tokens", 512);
//        requestBody.put("temperature", 0.5);
//
//        JSONArray messageArray = new JSONArray();
//
//        JSONObject message = new JSONObject();
//        message.put("role", "user");
//        message.put("content", prompt);
//        messageArray.put(message);
//
//        requestBody.put("messages", messageArray);
//
//        // Print out the JSON request as a string so we can look at it.
//        System.out.println(requestBody.toString());
//
//        // Set up the model request
//        InvokeModelRequest modelRequest = new InvokeModelRequest();
//
//        // Define which model we are using
//        modelRequest.setModelId("anthropic.claude-3-5-sonnet-20240620-v1:0");
//
//        // Convert our JSON request promt into bytes for the body of our request
//        modelRequest.setBody(ByteBuffer.wrap(requestBody.toString().getBytes()));
//
//        // Send the request to the model
//        InvokeModelResult modelResult = bedrockRuntime.invokeModel(modelRequest);
//
//        // Extract the request body from the response
//        String responseBodyJsonString = StandardCharsets.UTF_8.decode(modelResult.getBody()).toString();
//
//        JSONObject resourceBodyJSON = new JSONObject(responseBodyJsonString);
//
//        // Print out the response so we can see it
//        System.out.println(resourceBodyJSON.toString());


        String prompt = "Explain the theory of relativity in simple terms.";
        String response = userToolsService.syncResponse(prompt);
        System.out.println("Bedrock Response: " + response);
    }

    @GetMapping("/all")
    public ResponseEntity<List<VUserCurrentRoleRequirements>> getAll() {
        return ResponseEntity.ok(vUserToolsService.getAllCurrentRoleRequirements());
    }

    @GetMapping("/skillsLatest")
    public ResponseEntity<List<?>> getAllSkillsLatest() {
        return ResponseEntity.ok(vUserToolsService.getAllUserSkillsLatest());
    }

    @GetMapping("/skillsGaps")
    public ResponseEntity<List<?>> getAllSkillsGaps() {
        return ResponseEntity.ok(vUserToolsService.getAllUserSkillsGaps());
    }

    @GetMapping("/targetRoleRequirements")
    public ResponseEntity<List<?>> getAllTargetRoleRequirements() {
        return ResponseEntity.ok(vUserToolsService.getAllUserTargetRoleRequirements());
    }

}
