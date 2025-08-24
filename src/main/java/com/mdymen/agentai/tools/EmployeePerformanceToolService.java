package com.mdymen.agentai.tools;

import com.mdymen.agentai.entity.EmployeePerformance;
import com.mdymen.agentai.repository.EmployeePerformanceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeePerformanceToolService {

    private final EmployeePerformanceRepository employeePerformanceRepository;

    @Tool(name = "Get Employee Performance Data", description = "Get employee performance data by employee name")
    public EmployeePerformance getEmployeePerformanceData(String employeeName) {
        log.info("Fetching performance data for employee: {}", employeeName);
        EmployeePerformance employeePerformance = employeePerformanceRepository.findByEmployeeName(employeeName).orElse(null);
        log.info("Retrieved performance data: {}", employeePerformance);
        return employeePerformance;
    }


}
