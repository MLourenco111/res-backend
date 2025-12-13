package com.fiap.res.interfaces;

import com.fiap.res.domains.Owner;

import java.util.Optional;

public interface IOwnerGateway {

    Optional<Owner> findById(Long aLong);
}
