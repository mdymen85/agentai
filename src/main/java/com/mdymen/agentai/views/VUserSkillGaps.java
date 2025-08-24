package com.mdymen.agentai.views;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "v_user_skill_gaps")
@Entity
public class VUserSkillGaps {

    @Id
    private String userId;
    private String firstName;
    private String skillId;
    private int currentScore;
    private int targetRequired;
    private int gap;
    private int weighting;

    /**
     * Constructs a new VUserSkillGaps object.
     *
     * @param userId         The ID of the user.
     * @param skillId        The ID of the skill.
     * @param currentScore   The user's current skill score.
     * @param targetRequired The required proficiency for the target role.
     * @param gap            The difference between the target and current score.
     * @param weighting      The weighting of the skill in the role requirements.
     */
    public VUserSkillGaps(String userId, String skillId, int currentScore, int targetRequired, int gap, int weighting) {
        this.userId = userId;
        this.skillId = skillId;
        this.currentScore = currentScore;
        this.targetRequired = targetRequired;
        this.gap = gap;
        this.weighting = weighting;
    }

    public VUserSkillGaps() {

    }
}