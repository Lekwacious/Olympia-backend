package com.lekwacious.olympia.data.payloads.request;

import com.lekwacious.olympia.data.models.Club;
import lombok.Data;

import java.time.Instant;

@Data
public class Profile {
    private String email;
    private String firstName;
    private String lastName;
    private String gender;
    private String profilePics;
    private Double height;
    private String awards;
    private Club Club;


    public Profile(String email, String firstName, String lastName, String gender, String profilePics, Double height, String awards, com.lekwacious.olympia.data.models.Club club) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.profilePics = profilePics;
        this.height = height;
        this.awards = awards;
        Club = club;
    }
}
