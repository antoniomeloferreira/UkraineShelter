package com.ukraine.ukraineshelter.service;

import com.ukraine.ukraineshelter.dao.ContactDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactTypeService {

    @Autowired
    ContactDao contactDao;
}
