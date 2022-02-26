package com.ukraine.ukraineshelter.controller;

import com.ukraine.ukraineshelter.service.ShelterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/shelter")
public class ShelterController {

    @Autowired
    ShelterService shelterService;
}
