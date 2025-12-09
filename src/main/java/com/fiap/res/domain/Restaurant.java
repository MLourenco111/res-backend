package com.fiap.res.domain;

import com.fiap.res.CuisineType;
import com.fiap.res.InvalidRestaurantException;
import com.fiap.res.StringTransform;

import java.time.LocalTime;

public class Restaurant {

    private Long id;
    private final String name;
    private final String taxId;
    private final String branchCode;
    private final CuisineType cuisineType;
    private final LocalTime openingTime;
    private final LocalTime closingTime;
    private final Long ownerId;
    private final Address address;

    private Restaurant(Long id, String name,String taxId, String branchCode, CuisineType cuisineType,
                       LocalTime openingTime, LocalTime closingTime,
                       Long ownerId, Address address) {
        this.id = id;
        this.name = name;
        this.cuisineType = cuisineType;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        this.ownerId = ownerId;
        this.address = address;
        this.taxId = taxId;
        this.branchCode = branchCode;
        validate();
    }

    public static Restaurant create(String name,String taxId, String branchCode, CuisineType cuisineType,
                                    LocalTime opening, LocalTime closing,
                                    Long ownerId, Address address) {
        return new Restaurant(null, name,taxId, branchCode, cuisineType, opening, closing, ownerId, address);
    }

    public static Restaurant withId(Long id, String name ,String taxId, String branchCode, CuisineType cuisineType,
                                    LocalTime opening, LocalTime closing,
                                    Long ownerId, Address address) {
        return new Restaurant(id, name,taxId, branchCode, cuisineType, opening, closing, ownerId, address);
    }

    private void validate() {
        if (name == null || name.isBlank()) throw new InvalidRestaurantException("O restaurante deve ser informado");
        if (ownerId == null) throw new InvalidRestaurantException("O dono deve ser informado");
        if (openingTime == null || closingTime == null) throw new InvalidRestaurantException("Horas de funcionamento são obrigatórias");
        if (openingTime.isAfter(closingTime)) throw new InvalidRestaurantException("A hora de abertura deve ser anterior a hora de fechamento");
        if (address == null) throw new InvalidRestaurantException("Endereço é obrigatório");
        if(taxId == null || taxId.isBlank()) throw new InvalidRestaurantException("TaxId invalido ");
        if(branchCode == null || branchCode.isBlank()) throw new InvalidRestaurantException("BranchCode invalido ");
        //validar se o cnpj tem dados validos
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public CuisineType getCuisineType() { return cuisineType; }
    public LocalTime getOpeningTime() { return openingTime; }
    public LocalTime getClosingTime() { return closingTime; }
    public Long getOwnerId() { return ownerId; }
    public Address getAddress() { return address; }
    public String getTaxId(){return  taxId;}
    public String getBranchCode(){return  branchCode;}
    public void setId(Long id) { this.id = id; }

}
