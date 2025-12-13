package com.fiap.res.interfaces;

import com.fiap.res.domains.Restaurant;

public interface IRestauranteGateway {

    Restaurant save(Restaurant restaurant);

    boolean existsByTaxIdAndBranchCode(String s, String s1);
}
