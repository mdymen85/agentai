package com.mdymen.agentai.tools;

import com.mdymen.agentai.repository.vrepositories.VUserCurrentRoleRequirementsRepository;
import com.mdymen.agentai.repository.vrepositories.VUserSkillLatestRepository;
import com.mdymen.agentai.repository.vrepositories.VUserSkillsGapsRepository;
import com.mdymen.agentai.repository.vrepositories.VUserTargetRoleRequirementsRepository;
import com.mdymen.agentai.views.VUserCurrentRoleRequirements;
import com.mdymen.agentai.views.VUserSkillGaps;
import com.mdymen.agentai.views.VUserSkillLatest;
import com.mdymen.agentai.views.VUserTargetRoleRequirements;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class VUserToolsService {

    private final VUserSkillsGapsRepository vUserSkillsGapsRepository;
    private final VUserSkillLatestRepository vUserSkillLatestRepository;
    private final VUserCurrentRoleRequirementsRepository vUserCurrentRoleRequirementsRepository;
    private final VUserTargetRoleRequirementsRepository vUserSkillProficiencyRepository;

    public List<VUserCurrentRoleRequirements> getAllCurrentRoleRequirements() {
        return vUserCurrentRoleRequirementsRepository.findAll();
    }

    public List<VUserSkillLatest> getAllUserSkillsLatest() {
        return vUserSkillLatestRepository.findAll();
    }

    public List<VUserSkillGaps> getAllUserSkillsGaps() {
        return vUserSkillsGapsRepository.findAll();
    }

    public List<VUserTargetRoleRequirements> getAllUserTargetRoleRequirements() {
        return vUserSkillProficiencyRepository.findAll();
    }


    @Tool(name = "userSkillsGaps", description = "Return the skill gaps for a specific user by first name")
    public List<VUserSkillGaps> getUserSkillsGapsByUserId(String firstName) {
        log.info("Fetching skill gaps for userId: {}", firstName);
        List<VUserSkillGaps> skillGaps = vUserSkillsGapsRepository.findByFirstName(firstName);
        log.info("Found {} skill gaps for user: {}", skillGaps.size(), firstName);
        return skillGaps;
    }
}
