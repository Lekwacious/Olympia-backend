package com.lekwacious.olympia.data.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
public class Footballer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Integer id;
    private String name;
    private String email;
    private String gender;
    private String phone;
    private Double height;
    private String awards;
    private String imageUrl;
    private String club;


    public Footballer(String name, String email, String gender, String phone, Double height, String awards, String imageUrl, String club) {
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.phone = phone;
        this.height = height;
        this.awards = awards;
        this.imageUrl = imageUrl;
        this.club = club;
    }
}
