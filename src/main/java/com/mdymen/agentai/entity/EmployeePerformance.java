package com.mdymen.agentai.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.Data;

@Entity
@Table(name = "employee_performance")
@Data
public class EmployeePerformance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long employeeId;

    @Column(name = "employee_name", nullable = false)
    private String employeeName;

    @Column(name = "actions_items_pendings", columnDefinition = "TEXT")
    private String actionsItemsPendings;

    @Column(name = "goals_closed", columnDefinition = "TEXT")
    private String goalsClosed;

    @Column(name = "current_open_goals", columnDefinition = "TEXT")
    private String currentOpenGoals;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

}