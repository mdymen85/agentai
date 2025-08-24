package com.mdymen.agentai.repository.vrepositories;

import com.mdymen.agentai.views.VUserTargetRoleRequirements;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VUserTargetRoleRequirementsRepository extends ListCrudRepository<VUserTargetRoleRequirements, String> {

}
