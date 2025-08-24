package com.mdymen.agentai.repository.vrepositories;

import com.mdymen.agentai.views.VUserSkillGaps;
import java.util.List;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VUserSkillsGapsRepository extends ListCrudRepository<VUserSkillGaps, String> {

    List<VUserSkillGaps> findByUserId(String userId);

    List<VUserSkillGaps> findByFirstName(String firstName);
}
