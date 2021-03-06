package com.ukraine.ukraineshelter.controller;

import com.ukraine.ukraineshelter.entity.ShelterEntity;
import com.ukraine.ukraineshelter.model.dto.ShelterCreationDto;
import com.ukraine.ukraineshelter.model.dto.ShelterDto;
import com.ukraine.ukraineshelter.service.ShelterService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    @PutMapping(path = "update")
    public ResponseEntity<ShelterDto> updateShelter(@RequestBody ShelterEntity aShelterEntity) {

        ShelterDto updatedShelter = shelterService.updateShelter(aShelterEntity);

        return updatedShelter != null ? new ResponseEntity<>(updatedShelter, HttpStatus.OK) : new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping(path = "delete")
    public ResponseEntity<Boolean> deleteShelter(@RequestBody ShelterEntity aShelterEntity) {

        Boolean isDeleted = shelterService.deleteShelter(aShelterEntity);
        return isDeleted ? new ResponseEntity<>(true, HttpStatus.OK) : new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
    }

    @GetMapping(path = "list")
    public ResponseEntity<List<ShelterDto>> getShelterListByCountry(@RequestParam String aCountry) {

        List<ShelterDto> shelterList = new ArrayList<>();

        if (aCountry.equals("")) {

            shelterList = shelterService.getShelterList();

            return new ResponseEntity<>(shelterList, HttpStatus.OK);
        }

        shelterList = shelterService.getShelterListByCountry(aCountry);

        return new ResponseEntity<>(shelterList, HttpStatus.OK);
    }
}
