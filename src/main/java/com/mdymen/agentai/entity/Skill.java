package com.mdymen.agentai.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "skills")
@Data
public class Skill {

    @Id
    @Column(name = "skill_id", length = 36)
    private String skillId;

    @Column(name = "skill_name", nullable = false, columnDefinition = "TEXT")
    private String skillName;

    @Column(name = "skill_category", columnDefinition = "TEXT")
    private String skillCategory;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    // Getters and Setters
}