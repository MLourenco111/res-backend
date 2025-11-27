package com.fiap.res.domain;

import java.time.LocalTime;

public class Restaurant {

    private  Long id;
    private  String name;
    private  String cuisineType;
    private  WorkingHours workingHours;
    private  Address address;
    private  Long ownerId;

    public Restaurant(){
    }

    public void giveName(String name){
        //validar null
        this.name = name;
    }

    public void linkOwner(Long ownerId){
       //validar null
        this.ownerId = ownerId;
    }

    public void defineWorkingHours(LocalTime openingTime,LocalTime closingTime){
        this.workingHours = new WorkingHours(openingTime, closingTime);
    }

}
