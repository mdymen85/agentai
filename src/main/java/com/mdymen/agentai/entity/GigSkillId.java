package com.mdymen.agentai.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import lombok.Data;

@Embeddable
@Data
public class GigSkillId implements Serializable {

    @Column(name = "gig_id", length = 36)
    private String gigId;

    @Column(name = "skill_id", length = 36)
    private String skillId;

    // hashCode, equals, getters, setters
}