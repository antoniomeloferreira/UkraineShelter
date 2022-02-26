package com.ukraine.ukraineshelter.model;

public class Shelter {

    private Integer id;
    private Integer contactId;
    private String country;
    private String city;
    private Integer numberOfBeds;
    private Integer securityCode;
    private Boolean isPetFriendly;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getContactId() {
        return contactId;
    }

    public void setContactId(Integer contactId) {
        this.contactId = contactId;
    }

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
        return isPetFriendly;
    }

    public void setPetFriendly(Boolean petFriendly) {
        isPetFriendly = petFriendly;
    }
}
