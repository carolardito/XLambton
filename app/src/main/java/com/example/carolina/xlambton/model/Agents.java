package com.example.carolina.xlambton.model;

import java.io.Serializable;

public class Agents implements Serializable {

    private Long id;
    private String name;
    private String level;
    private String agency;
    private String website;
    private String country;
    private String phone;
    private String address;
    private String photo;

    /*public Agents(int id, String name, String level, String agency, String website, String country, String phone, String address) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.agency = agency;
        this.website = website;
        this.country = country;
        this.phone = phone;
        this.address = address;
    }*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
