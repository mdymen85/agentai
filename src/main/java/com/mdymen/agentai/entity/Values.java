package com.mdymen.agentai.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "values")
@Data
public class Values {

    @Id
    @Column(name = "value_id", length = 36)
    private String valueId;

    @Column(name = "value_name", nullable = false, columnDefinition = "TEXT")
    private String valueName;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    // Getters and Setters
}