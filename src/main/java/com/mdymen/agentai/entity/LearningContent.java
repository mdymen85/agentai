package com.mdymen.agentai.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "learning_content")
@Data
public class LearningContent {

    @Id
    @Column(name = "learning_id", length = 36)
    private String learningId;

    @Column(name = "title", nullable = false, columnDefinition = "TEXT")
    private String title;

    @Column(name = "provider", columnDefinition = "TEXT")
    private String provider;

    @Column(name = "content_type", columnDefinition = "TEXT")
    private String contentType;

    @Column(name = "url", columnDefinition = "TEXT")
    private String url;

    @Column(name = "duration_minutes")
    private Integer durationMinutes;

    @Column(name = "level", columnDefinition = "TEXT")
    private String level;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    // Getters and Setters
}