package com.lekwacious.olympia.data.payloads.request;

import com.lekwacious.olympia.data.models.Roles;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Data
public class SignUpRequest {
    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Size(min = 5)
    private String password;

    @NotBlank
    @Size(min = 4, max = 50)
    private String firstName;

    @NotBlank
    @Size(min = 4, max = 50)
    private String lastName;

    private Set<String> roles = new HashSet<>();



}
