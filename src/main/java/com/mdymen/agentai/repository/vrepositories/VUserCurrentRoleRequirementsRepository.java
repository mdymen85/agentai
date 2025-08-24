package com.mdymen.agentai.repository.vrepositories;

import com.mdymen.agentai.views.VUserCurrentRoleRequirements;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VUserCurrentRoleRequirementsRepository extends ListCrudRepository<VUserCurrentRoleRequirements, String> {

}
