package com.lekwacious.olympia.service;

import com.lekwacious.olympia.data.models.Footballer;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface FootballerService {
    Footballer addFootballer(Footballer footballer);
    List<Footballer> findAllFootballers();
    Footballer updateFootballer(Footballer footballer);
    Footballer findFootballerById(Integer id);
    void deleteFootballer(Integer id);
}
