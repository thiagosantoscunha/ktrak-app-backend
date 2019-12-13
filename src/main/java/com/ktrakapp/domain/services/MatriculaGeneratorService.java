package com.ktrakapp.domain.services;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.UUID;

public abstract class MatriculaGeneratorService {

    public static String build() {
        Integer year = LocalDate.now().getYear();
        String id = String.format("%040d", new BigInteger(UUID.randomUUID().toString().replace("-", ""), 16)).substring(0, 8);
        return year + id;
    }

}
