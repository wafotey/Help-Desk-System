package com.miu.edu.infastructure.entities;

import jakarta.persistence.Embeddable;

@Embeddable
public class AddressEntity {
    private String country;
    private String city;
    private String state;
    private String zip;
    private String street;

    protected AddressEntity() {}

    public AddressEntity(String country, String city, String state, String zip, String street) {
        this.country = country;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.street = street;
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
