package com.mdymen.agentai.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.Data;

@Entity
@Table(name = "assessments")
@Data
public class Assessment {

    public enum AssessorType {
        self, peer, manager
    }

    @Id
    @Column(name = "assessment_id", length = 36)
    private String assessmentId;

    @Column(name = "user_id", length = 36)
    private String userId;

    @Column(name = "skill_id", length = 36)
    private String skillId;

    @Enumerated(EnumType.STRING)
    @Column(name = "assessor_type")
    private AssessorType assessorType;

    @Column(name = "assessor_user_id", length = 36)
    private String assessorUserId;

    @Column(name = "score", nullable = false)
    private Integer score;

    @Column(name = "assessed_at", nullable = false)
    private LocalDateTime assessedAt;

    // Getters and Setters
}