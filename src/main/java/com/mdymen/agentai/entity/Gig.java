package com.mdymen.agentai.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import lombok.Data;

@Entity
@Table(name = "gigs")
@Data
public class Gig {

    @Id
    @Column(name = "gig_id", length = 36)
    private String gigId;

    @Column(name = "title", nullable = false, columnDefinition = "TEXT")
    private String title;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "department", columnDefinition = "TEXT")
    private String department;

    @Column(name = "location", columnDefinition = "TEXT")
    private String location;

    @Column(name = "url", columnDefinition = "TEXT")
    private String url;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "time_commitment_pct")
    private Integer timeCommitmentPct;

    @Column(name = "owner_user_id", length = 36)
    private String ownerUserId;

    // Getters and Setters
}
