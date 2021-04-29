package com.lekwacious.olympia.data.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.List;

@Table(name = "my_roles")
@Data
@Entity
@NoArgsConstructor
public class Roles {

    @Column(name = "role_id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @NaturalId
    private Usertype name;



    public Roles(Usertype name) {
        this.name = name;
    }

}
