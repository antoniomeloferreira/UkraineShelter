package com.ukraine.ukraineshelter.service;

import com.ukraine.ukraineshelter.dao.ShelterDao;
import com.ukraine.ukraineshelter.entity.ShelterEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShelterService {

    @Autowired
    ShelterDao shelterDao;
}
