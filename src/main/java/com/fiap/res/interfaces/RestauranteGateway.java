package com.fiap.res.interfaces;

import com.fiap.res.domain.Restaurant;

import java.util.Optional;

public interface RestauranteGateway {

    Restaurant save(Restaurant restaurant);

    boolean existsByTaxIdAndBranchCode(String s, String s1);
}
