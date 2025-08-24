package com.mdymen.agentai.views;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "v_user_current_role_requirements")
@Data
public class VUserCurrentRoleRequirements {

    @Id
    private String userId;
    private String skillId;
    private int requiredProficiency;
    private int weighting;

    /**
     * Constructs a new VUserCurrentRoleRequirements object.
     *
     * @param userId              The ID of the user.
     * @param skillId             The ID of the skill.
     * @param requiredProficiency The proficiency level required for this skill.
     * @param weighting           The weighting of the skill in the role requirements.
     */
    public VUserCurrentRoleRequirements(String userId, String skillId, int requiredProficiency, int weighting) {
        this.userId = userId;
        this.skillId = skillId;
        this.requiredProficiency = requiredProficiency;
        this.weighting = weighting;
    }

    public VUserCurrentRoleRequirements() {

    }
}