package com.fiap.res.domain;

import java.time.LocalTime;

public class WorkingHours {

    private final LocalTime openingTime;
    private final LocalTime closingTime;

    public WorkingHours(LocalTime openingTime, LocalTime closingTime){
        //validar se horas nao sao nulas
        //validar se hora de abertura e menor que hora de fechamento

        this.openingTime = openingTime;
        this.closingTime = closingTime;
    }
}
