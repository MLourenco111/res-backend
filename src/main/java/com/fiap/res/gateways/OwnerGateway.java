package com.fiap.res.gateways;

import com.fiap.res.OwnerDto;
import com.fiap.res.domains.Owner;
import com.fiap.res.interfaces.IDataSource;
import com.fiap.res.interfaces.IOwnerGateway;
import com.fiap.res.interfaces.IRestauranteGateway;

import java.util.Optional;

import static java.util.Objects.isNull;

public class OwnerGateway implements IOwnerGateway {

    private final IDataSource dataSource;

    public OwnerGateway(IDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public static  OwnerGateway create (IDataSource dataSource){
        return  new OwnerGateway(dataSource);
    }

    @Override
    public Optional<Owner> findById(Long idOwner){
        if(isNull(idOwner)){
            throw new RuntimeException("implementar exception personalizada");
        }

        OwnerDto ownerDto =  this.dataSource.findById(idOwner);
        Owner owner =Owner.create(ownerDto.id(),
                                ownerDto.name(),
                                ownerDto.types());
        return Optional.of(owner);
    }
}
