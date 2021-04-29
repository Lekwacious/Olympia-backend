package com.lekwacious.olympia.data.repository;

import com.lekwacious.olympia.data.models.Footballer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FootballerRepository extends JpaRepository<Footballer, Integer> {
    void deleteFootballerById(Integer id);

    Optional<Footballer> findFootballerById(Integer id);
}
