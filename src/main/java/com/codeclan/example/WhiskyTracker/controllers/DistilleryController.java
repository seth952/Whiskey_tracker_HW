package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository.DistilleryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/distilleries")
public class DistilleryController {
    @Autowired
    private DistilleryRepository distilleryRepository;

    @GetMapping(value = "/distilleries/{region}")
    public ResponseEntity<List<Distillery>> findAllWhiskies(String region) {
        List<Distillery> distilleries = distilleryRepository.findDistilleryByRegion(region);
        return new ResponseEntity<>(distilleries, HttpStatus.OK);
    }

}
