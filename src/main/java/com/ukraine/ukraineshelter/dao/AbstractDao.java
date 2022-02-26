package com.ukraine.ukraineshelter.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
@Transactional
public class AbstractDao {

    @Autowired
    EntityManager em;
}
