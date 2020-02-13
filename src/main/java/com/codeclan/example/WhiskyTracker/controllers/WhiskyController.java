package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/whiskies")
public class WhiskyController {
    @Autowired
    private WhiskyRepository whiskyRepository;


    @GetMapping(value = "/whiskies/{year}")
    public ResponseEntity<List<Whisky>> findAllWhiskies(int year) {
        List<Whisky> whiskies = whiskyRepository.findWhiskiesByYear(year);
        return new ResponseEntity<>(whiskies, HttpStatus.OK);
    }

    @GetMapping(value = "/whiskies/distilleries")
    public ResponseEntity<List<Whisky>> findAllWhiskiesByDistilleryAge(@RequestParam(name= "name") String distillery,@RequestParam(name="age") int age) {
        List<Whisky> whiskies = whiskyRepository.findWhiskyByDistilleryNameAndAge(distillery, age);
        return new ResponseEntity<>(whiskies, HttpStatus.OK);

    }
}
