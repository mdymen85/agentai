package com.mdymen.agentai.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.Data;

@Entity
@Table(name = "career_preferences")
@Data
public class CareerPreference {

    @Id
    @Column(name = "user_id", length = 36)
    private String userId;

    @Column(name = "preference", columnDefinition = "TEXT")
    private String preference;

    @Column(name = "notes", columnDefinition = "TEXT")
    private String notes;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    // Getters and Setters
}