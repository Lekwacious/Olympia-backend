package com.lekwacious.olympia.web;

import com.lekwacious.olympia.data.models.Footballer;
import com.lekwacious.olympia.service.FootballerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/footballer")
public class FootballerController {
    private final FootballerService footballerService;

    public FootballerController(FootballerService footballerService) {
        this.footballerService = footballerService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Footballer>> getAllEmployees () {
        List<Footballer> footballers = footballerService.findAllFootballers();
        return new ResponseEntity<>(footballers, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Footballer> getEmployeeById (@PathVariable("id") Integer id) {
        Footballer employee = footballerService.findFootballerById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Footballer> addEmployee(@RequestBody Footballer footballer) {
        Footballer newEmployee = footballerService.addFootballer(footballer);
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Footballer> updateEmployee(@RequestBody Footballer footballer) {
        Footballer updateEmployee = footballerService.updateFootballer(footballer);
        return new ResponseEntity<>(updateEmployee, HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Integer id) {
        footballerService.deleteFootballer(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
