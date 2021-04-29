package com.lekwacious.olympia.service;

import com.lekwacious.olympia.data.models.Footballer;
import com.lekwacious.olympia.data.repository.FootballerRepository;
import com.lekwacious.olympia.service.exception.FootballerNotFoundException;
import com.lekwacious.olympia.service.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class FootballerServiceImpl implements FootballerService {

    private final FootballerRepository footballerRepository;

    @Autowired
    public FootballerServiceImpl(FootballerRepository footballerRepository) {
        this.footballerRepository = footballerRepository;
    }

    @Override
    public Footballer addFootballer(Footballer footballer) {
        return footballerRepository.save(footballer);
    }

    @Override
    public List<Footballer> findAllFootballers() {
        return footballerRepository.findAll();
    }

    @Override
    public Footballer updateFootballer(Footballer footballer) {
        return footballerRepository.save(footballer);
    }

    @Override
    public Footballer findFootballerById(Integer id) {
        return footballerRepository.findFootballerById(id).orElseThrow(()-> new FootballerNotFoundException("Footballer not found"));
    }

    @Override
    public void deleteFootballer(Integer id) {
        footballerRepository.deleteFootballerById(id);
    }
}
