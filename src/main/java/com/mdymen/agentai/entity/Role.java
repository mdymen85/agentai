package com.mdymen.agentai.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.Data;

@Entity
@Table(name = "roles")
@Data
public class Role {

    @Id
    @Column(name = "role_id", length = 36)
    private String roleId;

    @Column(name = "role_name", nullable = false, columnDefinition = "TEXT")
    private String roleName;

    @Column(name = "role_family", columnDefinition = "TEXT")
    private String roleFamily;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    // Getters and Setters
}
