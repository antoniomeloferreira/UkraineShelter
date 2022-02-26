package com.ukraine.ukraineshelter.entity;

import javax.persistence.*;

@Entity
@Table(name = "shelter")
@NamedQueries({
        @NamedQuery(name = "ShelterEntity.getByCountry", query = "SELECT s FROM ShelterEntity s WHERE s.country=:country"),
        @NamedQuery(name = "ShelterEntity.getByCity", query = "SELECT s FROM ShelterEntity s WHERE s.city=:city"),
        @NamedQuery(name = "ShelterEntity.getByContact", query = "SELECT s FROM ShelterEntity s WHERE s.contactId=:contact_id"),
        @NamedQuery(name = "ShelterEntity.getByNumberOfBeds", query = "SELECT s FROM ShelterEntity s WHERE s.numberOfBeds=:number_of_beds")
})
public class ShelterEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "contact_id")
    private Integer contactId;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @Column(name = "number_of_beds")
    private Integer numberOfBeds;

    @Column(name = "security_code")
    private Integer securityCode;

    @Column(name = "pet_friendly")
    private Boolean petFriendly;

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
        return petFriendly;
    }

    public void setPetFriendly(Boolean petFriendly) {
        this.petFriendly = petFriendly;
    }

    @Override
    public String toString() {
        return "ShelterEntity{" +
                "id=" + id +
                ", contactId=" + contactId +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", numberOfBeds=" + numberOfBeds +
                ", securityCode=" + securityCode +
                ", isPetFriendly=" + petFriendly +
                '}';
    }
}
