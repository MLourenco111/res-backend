package com.fiap.res.domains;

public class Address {

    private Long id;
    private String street;
    private String number;
    private String city;
    private String state;
    private String country;
    private String zipCode;

    public Address(Long id,String street, String number, String city, String state, String country, String zipCode) {
        this.street = street;
        this.id = id;
        this.number = number;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zipCode = zipCode;
    }

    private void validate() {
    //validar todos os campos do enderecojkl;''''''''''
    }
    public Long getId() {
        return id;
    }

    public String getStreet() {
        return street;
    }

    public String getNumber() {
        return number;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getZipCode() {
        return zipCode;
    }
}
