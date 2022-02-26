package com.ukraine.ukraineshelter.service;

import com.ukraine.ukraineshelter.dao.LocationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationService {

    @Autowired
    LocationDao locationDao;
}
