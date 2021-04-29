package com.lekwacious.olympia.data.models;

import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private String city;

    private String coach;

    public Club(String name, String city, String coach) {
        this.name = name;
        this.city = city;
        this.coach = coach;
    }
}
