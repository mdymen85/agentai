package com.mdymen.agentai.repository;

import com.mdymen.agentai.entity.EmployeeProfile;
import java.util.Optional;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends ListCrudRepository<EmployeeProfile, Long> {

    Optional<EmployeeProfile> findByFirstName(String firstName);
}
