package com.ukraine.ukraineshelter.entity;

import javax.persistence.*;

@Entity
@Table(name = "shelter")
@NamedQueries({
        @NamedQuery(name = "ShelterEntity.getByLocation", query = "SELECT u FROM ShelterEntity u WHERE u.locationId=:location_id"),
        @NamedQuery(name = "ShelterEntity.getByContact", query = "SELECT u FROM ShelterEntity u WHERE u.contactId=:contact_id"),
        @NamedQuery(name = "ShelterEntity.getByBedNumber", query = "SELECT u FROM ShelterEntity u WHERE u.bedNumber=:bed_number")
})
public class ShelterEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "location_id")
    private Integer locationId;

    @Column(name = "contact_id")
    private Integer contactId;

    @Column(name = "bed_number")
    private Integer bedNumber;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public Integer getContactId() {
        return contactId;
    }

    public void setContactId(Integer contactId) {
        this.contactId = contactId;
    }

    public Integer getBedNumber() {
        return bedNumber;
    }

    public void setBedNumber(Integer bedNumber) {
        this.bedNumber = bedNumber;
    }
}
