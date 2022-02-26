package com.ukraine.ukraineshelter.model.dto;

import com.ukraine.ukraineshelter.entity.ContactEntity;

public class ShelterDto {

    private String country;
    private String city;
    private ContactEntity contact;
    private Integer numberOfBeds;
    private Boolean isPetFriendly;

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

    public Boolean getPetFriendly() {
        return isPetFriendly;
    }

    public void setPetFriendly(Boolean petFriendly) {
        isPetFriendly = petFriendly;
    }

    @Override
    public String toString() {
        return "ShelterDto{" +
                "country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", contact=" + contact +
                ", numberOfBeds=" + numberOfBeds +
                ", isPetFriendly=" + isPetFriendly +
                '}';
    }
}
