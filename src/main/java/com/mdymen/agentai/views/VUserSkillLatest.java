package com.mdymen.agentai.views;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "v_user_skill_latest")
public class VUserSkillLatest {

    @Id
    private String userId;
    private String skillId;
    private int latestScore;
    private String latestAssessorType;
    private java.util.Date latestAssessedAt;

    /**
     * Constructs a new VUserSkillLatest object.
     *
     * @param userId             The ID of the user.
     * @param skillId            The ID of the skill.
     * @param latestScore        The score from the most recent assessment.
     * @param latestAssessorType The type of assessor (e.g., "Self", "Manager", "Peer").
     * @param latestAssessedAt   The timestamp of the most recent assessment.
     */
    public VUserSkillLatest(String userId, String skillId, int latestScore, String latestAssessorType, java.util.Date latestAssessedAt) {
        this.userId = userId;
        this.skillId = skillId;
        this.latestScore = latestScore;
        this.latestAssessorType = latestAssessorType;
        this.latestAssessedAt = latestAssessedAt;
    }

    public VUserSkillLatest() {

    }
}