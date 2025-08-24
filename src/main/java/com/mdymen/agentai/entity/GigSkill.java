package com.mdymen.agentai.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "gig_skills")
@Data
public class GigSkill {

    @EmbeddedId
    private GigSkillId id;

    @Column(name = "impact_level", columnDefinition = "TEXT")
    private String impactLevel;

    @Column(name = "notes", columnDefinition = "TEXT")
    private String notes;

    // Getters and Setters
}