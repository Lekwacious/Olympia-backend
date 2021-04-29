package com.lekwacious.olympia.data.payloads.response;

import lombok.Data;

@Data
public class UserSummary {
    private Integer id;
    private String username;
    private String firstName;
    private String lastName;

    public UserSummary(Integer id, String username, String firstName, String lastName) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
