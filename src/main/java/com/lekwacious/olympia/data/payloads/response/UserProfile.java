package com.lekwacious.olympia.data.payloads.response;


import lombok.Data;



@Data
public class UserProfile {
    private Integer id;
    private String email;
    private String firstName;
    private String lastName;




    public UserProfile(Integer id, String email, String firstName, String lastName) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;


    }
}
