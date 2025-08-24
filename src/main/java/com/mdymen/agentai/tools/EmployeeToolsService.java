package com.mdymen.agentai.tools;

import com.mdymen.agentai.entity.EmployeeProfile;
import com.mdymen.agentai.entity.User;
import com.mdymen.agentai.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class EmployeeToolsService {

    private final EmployeeRepository employeeRepository;

    @Tool(name = "employee", description = "The primary purpose of this tool is to provide a holistic view "
                                           + "of an employee by retrieving all of their characteristics. "
                                           + "This data can then be used to draw conclusions, perform analyses, "
                                           + "or make informed decisions about their career path, training needs, "
                                           + "and potential for new roles.")
    public EmployeeProfile employee(String firstName) {
        log.info("Fetch information for employee with first name: {}", firstName);
        return employeeRepository.findByFirstName(firstName)
                             .orElse(null);
    }

}
