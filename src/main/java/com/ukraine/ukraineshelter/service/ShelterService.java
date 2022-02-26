package com.ukraine.ukraineshelter.service;

import com.ukraine.ukraineshelter.dao.ContactDao;
import com.ukraine.ukraineshelter.dao.ShelterDao;
import com.ukraine.ukraineshelter.entity.ContactEntity;
import com.ukraine.ukraineshelter.entity.ShelterEntity;
import com.ukraine.ukraineshelter.model.Shelter;
import com.ukraine.ukraineshelter.model.dto.ShelterCreationDto;
import com.ukraine.ukraineshelter.model.dto.ShelterDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShelterService {

    @Autowired
    ShelterDao shelterDao;

    @Autowired
    ContactDao contactDao;

    public ShelterDto addShelter(ShelterCreationDto aShelterCreationDto) {

        ContactEntity contactEntity = getContactEntityFromShelterCreationDto(aShelterCreationDto);
        ShelterEntity shelterEntity = fromShelterCreationDtoToShelterEntity(aShelterCreationDto);

        ContactEntity persistedContact = contactDao.addContact(contactEntity);

        if (persistedContact == null) {
            return null;
        }

        shelterEntity.setContactId(persistedContact.getId());

        ShelterEntity persistedShelter = shelterDao.addShelter(shelterEntity);

        return fromShelterEntityToShelterDto(persistedShelter);
    }

    public ShelterDto updateShelter(ShelterDto aShelterDto) {

        ShelterEntity shelterEntity = shelterDao.getById(aShelterDto.getId());

        shelterEntity.setCountry(aShelterDto.getCountry());
        shelterEntity.setCity(aShelterDto.getCity());
        shelterEntity.setNumberOfBeds(aShelterDto.getNumberOfBeds());
        shelterEntity.setPetFriendly(aShelterDto.getPetFriendly());

        ShelterEntity updatedShelter = shelterDao.update(shelterEntity);

        return fromShelterEntityToShelterDto(updatedShelter);
    }

    public Boolean deleteShelter (ShelterEntity aShelterEntity) {

        ShelterEntity persistedEntity = shelterDao.getById(aShelterEntity.getId());

        if (!aShelterEntity.getSecurityCode().equals(persistedEntity.getSecurityCode())) {
            return false;
        }

        return shelterDao.delete(aShelterEntity);
    }

    public List<ShelterDto> getShelterList() {

        List<ShelterEntity> shelterEntityList = shelterDao.getShelterList();
        List<ShelterDto> shelterDtoList = fromShelterEntityListToShelterDtoList(shelterEntityList);

        return shelterDtoList;
    }

    public List<ShelterDto> getShelterListByCountry(String aCountry) {

        List<ShelterEntity> shelterEntityList = shelterDao.getShelterListByCountry(aCountry);
        List<ShelterDto> shelterDtoList = fromShelterEntityListToShelterDtoList(shelterEntityList);

        return shelterDtoList;
    }

    private List<ShelterDto> fromShelterEntityListToShelterDtoList(List<ShelterEntity> aShelterEntityList) {

        ArrayList<ShelterDto> shelterDtoList = new ArrayList<>();

        for (ShelterEntity s : aShelterEntityList) {
            shelterDtoList.add(fromShelterEntityToShelterDto(s));
        }

        return shelterDtoList;
    }

    private ShelterEntity fromShelterCreationDtoToShelterEntity (ShelterCreationDto aShelterCreationDto) {

        ShelterEntity shelterEntity = new ShelterEntity();

        shelterEntity.setCountry(aShelterCreationDto.getCountry());
        shelterEntity.setCity(aShelterCreationDto.getCity());
        shelterEntity.setNumberOfBeds(aShelterCreationDto.getNumberOfBeds());
        shelterEntity.setSecurityCode(aShelterCreationDto.getSecurityCode());
        shelterEntity.setPetFriendly(aShelterCreationDto.getPetFriendly());

        return shelterEntity;
    }

    private ShelterDto fromShelterEntityToShelterDto (ShelterEntity aShelterEntity) {

        ShelterDto shelterDto = new ShelterDto();
        ContactEntity contactEntity = contactDao.getContactById(aShelterEntity.getContactId());

        shelterDto.setId(aShelterEntity.getId());
        shelterDto.setCountry(aShelterEntity.getCountry());
        shelterDto.setCity(aShelterEntity.getCity());
        shelterDto.setNumberOfBeds(aShelterEntity.getNumberOfBeds());
        shelterDto.setContact(contactEntity);
        shelterDto.setPetFriendly(aShelterEntity.getPetFriendly());

        return shelterDto;
    }

    private ContactEntity getContactEntityFromShelterCreationDto(ShelterCreationDto aShelterCreationDto) {

        ContactEntity contactEntity = new ContactEntity();

        contactEntity.setContactType(aShelterCreationDto.getContact().getContactType());
        contactEntity.setNumber(aShelterCreationDto.getContact().getNumber());

        return contactEntity;
    }
}
