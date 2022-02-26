package com.ukraine.ukraineshelter.dao;

import com.ukraine.ukraineshelter.entity.ContactEntity;
import org.springframework.stereotype.Repository;

@Repository
public class ContactDao extends AbstractDao{

    public ContactEntity addContact (ContactEntity aContactEntity) {
        em.persist(aContactEntity);
        return aContactEntity;
    }

    public ContactEntity getContactById (Integer aId) {
        return em.find(ContactEntity.class, aId);
    }
}
