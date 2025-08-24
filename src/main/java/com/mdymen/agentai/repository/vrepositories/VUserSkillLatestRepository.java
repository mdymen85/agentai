package com.mdymen.agentai.repository.vrepositories;

import com.mdymen.agentai.views.VUserSkillLatest;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VUserSkillLatestRepository extends ListCrudRepository<VUserSkillLatest, String> {

}
