package com.mdymen.agentai.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "mentors")
@Data
public class Mentor {

    @Id
    @Column(name = "mentor_id", length = 36)
    private String mentorId;

    @Column(name = "mentor_name", nullable = false, columnDefinition = "TEXT")
    private String mentorName;

    @Column(name = "mentor_email", columnDefinition = "TEXT")
    private String mentorEmail;

    @Column(name = "internal_user_id", length = 36)
    private String internalUserId;

    @Column(name = "bio", columnDefinition = "TEXT")
    private String bio;

    @Column(name = "availability_notes", columnDefinition = "TEXT")
    private String availabilityNotes;

    @Column(name = "url", columnDefinition = "TEXT")
    private String url;

    // Getters and Setters
}