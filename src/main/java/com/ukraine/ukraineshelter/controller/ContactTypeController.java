package com.ukraine.ukraineshelter.controller;

import com.ukraine.ukraineshelter.service.ContactTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Access;

@RestController
@RequestMapping("/contact-type")
public class ContactTypeController {

    @Autowired
    ContactTypeService contactTypeService;
}
