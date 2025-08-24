package com.mdymen.agentai.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "employee_profiles")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeProfile {

    @Id
    private String employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private String currentRole;
    private String targetRole;
    private String personalValues;
    private String careerPreferences;

    // 360-Degree Skill Assessments (on a 1-5 scale)
    private int communicationSelf;
    private int communicationPeer;
    private int communicationManager;

    private int leadershipSelf;
    private int leadershipPeer;
    private int leadershipManager;

    private int technicalExpertiseSelf;
    private int technicalExpertisePeer;
    private int technicalExpertiseManager;

    private int projectManagementSelf;
    private int projectManagementPeer;
    private int projectManagementManager;

    private int analyticalThinkingSelf;
    private int analyticalThinkingPeer;
    private int analyticalThinkingManager;

    private int collaborationSelf;
    private int collaborationPeer;
    private int collaborationManager;

    private int creativitySelf;
    private int creativityPeer;
    private int creativityManager;

    private int problemSolvingSelf;
    private int problemSolvingPeer;
    private int problemSolvingManager;

    private int adaptabilitySelf;
    private int adaptabilityPeer;
    private int adaptabilityManager;

    private int timeManagementSelf;
    private int timeManagementPeer;
    private int timeManagementManager;

    // Professional Development Activities
    private String gigs;
    private String mentors;
    private String learningContent;

}