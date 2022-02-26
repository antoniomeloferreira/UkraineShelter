package com.ukraine.ukraineshelter.dao;

import com.ukraine.ukraineshelter.entity.ShelterEntity;
import com.ukraine.ukraineshelter.model.Shelter;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public class ShelterDao extends AbstractDao {

    private static final String PARAMETER_LOCATION = "country";

    public ShelterEntity addShelter(ShelterEntity aShelter) {
        em.persist(aShelter);
        return aShelter;
    }

    public List<ShelterEntity> getShelterList() {

        Query q = em.createNamedQuery("ShelterEntity.getAllShelters");
        return q.getResultList();
    }

    public List<ShelterEntity> getShelterListByCountry(String aCountry) {

        Query q = em.createNamedQuery("ShelterEntity.getByCountry");
        q.setParameter(PARAMETER_LOCATION, aCountry);

        List<ShelterEntity> shelterEntity = q.getResultList();

        return shelterEntity;
    }
}
