package com.mdymen.agentai.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "user_values")
public class UserValues {

    @Id
    private String userId;
    private String valueId;
    private short priority;

    /**
     * Constructs a new UserValues object.
     *
     * @param userId   The ID of the user.
     * @param valueId  The ID of the personal value.
     * @param priority The priority given to this value by the user.
     */
    public UserValues(String userId, String valueId, short priority) {
        this.userId = userId;
        this.valueId = valueId;
        this.priority = priority;
    }

    public UserValues() {

    }
}