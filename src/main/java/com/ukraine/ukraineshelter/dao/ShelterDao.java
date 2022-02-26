package com.ukraine.ukraineshelter.dao;

import com.ukraine.ukraineshelter.entity.ShelterEntity;
import com.ukraine.ukraineshelter.model.Shelter;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;

@Repository
public class ShelterDao extends AbstractDao {

    private static final String PARAMETER_LOCATION = "location";

    public ShelterEntity saveShelter(ShelterEntity aShelter) {
        em.persist(aShelter);
        return aShelter;
    }

    public ShelterEntity getByLocation(String aLocation) {
        Query q = em.createNamedQuery("ShelterEntity.getByLocation");
        q.setParameter(PARAMETER_LOCATION, aLocation);

        ShelterEntity shelterEntity = q.getSingleResult();

        return shelterEntity;
    }

    public ShelterEntity getByContact() {}

    public ShelterEntity getByBedNumber() {}

    public ShelterEntity deleteShelter() {}


}
