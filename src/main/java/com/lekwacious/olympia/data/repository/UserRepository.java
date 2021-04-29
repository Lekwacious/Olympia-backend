package com.lekwacious.olympia.data.repository;
import com.lekwacious.olympia.data.models.User;
import com.lekwacious.olympia.data.payloads.request.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findUserByEmail(String email);

    Boolean existsByEmail(String email);

    Boolean existsByFirstName(String firstName);

}
