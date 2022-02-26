package com.ukraine.ukraineshelter.model.dto;

import com.ukraine.ukraineshelter.entity.ContactEntity;

public class ShelterCreationDto {

    private String country;
    private String city;
    private ContactEntity contact;
    private Integer numberOfBeds;
    private Integer securityCode;
    private Boolean petFriendly;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public ContactEntity getContact() {
        return contact;
    }

    public void setContact(ContactEntity contact) {
        this.contact = contact;
    }

    public Integer getNumberOfBeds() {
        return numberOfBeds;
    }

    public void setNumberOfBeds(Integer numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    public Integer getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(Integer securityCode) {
        this.securityCode = securityCode;
    }

    public Boolean getPetFriendly() {
        return petFriendly;
    }

    public void setPetFriendly(Boolean petFriendly) {
        this.petFriendly = petFriendly;
    }

    @Override
    public String toString() {
        return "ShelterCreationDto{" +
                "country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", contact=" + contact +
                ", numberOfBeds=" + numberOfBeds +
                ", securityCode=" + securityCode +
                ", isPetFriendly=" + petFriendly +
                '}';
    }
}
