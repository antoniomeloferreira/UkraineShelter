package com.ukraine.ukraineshelter.controller;

import com.ukraine.ukraineshelter.model.dto.ShelterCreationDto;
import com.ukraine.ukraineshelter.model.dto.ShelterDto;
import com.ukraine.ukraineshelter.service.ShelterService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/shelter")
public class ShelterController {

    @Autowired
    ShelterService shelterService;

    @PostMapping(path = "add")
    public ResponseEntity<ShelterDto> addShelter (@RequestBody ShelterCreationDto aShelterCreationDto) {

        ShelterDto shelter = shelterService.addShelter(aShelterCreationDto);

        if (shelter == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(shelter, HttpStatus.OK);
    }

    @GetMapping(path = "list")
    public ResponseEntity<List<ShelterDto>> getShelterList() {

        List<ShelterDto> shelterList = shelterService.getShelterList();
        return new ResponseEntity<>(shelterList, HttpStatus.OK);
    }
}
