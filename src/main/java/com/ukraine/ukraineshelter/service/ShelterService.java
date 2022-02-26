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

@Service
public class ShelterService {

    @Autowired
    ShelterDao shelterDao;

    @Autowired
    ContactDao contactDao;

    public ShelterDto addShelter(ShelterCreationDto aShelterCreationDto) {

        System.out.println("Sout 1: " + aShelterCreationDto.getPetFriendly());

        ContactEntity contactEntity = getContactEntityFromShelterCreationDto(aShelterCreationDto);
        ShelterEntity shelterEntity = fromShelterCreationDtoToShelterEntity(aShelterCreationDto);

        ContactEntity persistedContact = contactDao.addContact(contactEntity);

        if (persistedContact == null) {
            return null;
        }

        shelterEntity.setContactId(persistedContact.getId());

        System.out.println("Sout 2: " + shelterEntity.getPetFriendly());
        ShelterEntity persistedShelter = shelterDao.addShelter(shelterEntity);

        return fromShelterEntityToShelterDto(persistedShelter);
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
