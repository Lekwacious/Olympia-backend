package com.lekwacious.olympia.data.payloads.response;

import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class JwtAuthenticationResponse {
    private Integer id;
    private String email;
    private String firstName;
    private String lastName;
    private String accessToken;
    private Set<String> roles;

    public JwtAuthenticationResponse(Integer id, String accessToken, String email, String firstName, String lastName, Set<String> roles) {
        this.id = id;
        this.accessToken = accessToken;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.roles = roles;
    }
}
