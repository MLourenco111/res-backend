package com.fiap.res.domains;

import org.springframework.util.CollectionUtils;

import java.util.List;

import static java.util.Objects.isNull;

public class Owner {
    private Long id;
    private String name;
    private List<String> types;

    private Owner(Long id, String name, List<String> types){
        this.id = id;
        this.name = name;
        this.types = types;
        validate();
    }
    public static Owner create(Long id,  String name, List<String> types){
        return new Owner(id,name, types);
    }


    private void validate(){
        if(isNull(id)) throw new RuntimeException();
        if(isNull(name)|| name.isBlank()) throw new RuntimeException();
        if(CollectionUtils.isEmpty(types) || types.isEmpty()) throw new RuntimeException();

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<String> getTypes() {
        return types;
    }
}
