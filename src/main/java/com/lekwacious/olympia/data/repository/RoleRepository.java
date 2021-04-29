package com.lekwacious.olympia.data.repository;

import com.lekwacious.olympia.data.models.Roles;
import com.lekwacious.olympia.data.models.Usertype;
import org.hibernate.usertype.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Roles, Integer> {
    Optional<Roles> findByName(Usertype name);

}
