package com.mdymen.agentai.repository;

import com.mdymen.agentai.entity.EmployeePerformance;
import java.util.Optional;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeePerformanceRepository extends ListCrudRepository<EmployeePerformance, Long> {

    Optional<EmployeePerformance> findByEmployeeName(String employeeName);
}
