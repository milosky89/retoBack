package com.retobackend.api.util;

import com.github.javafaker.Faker;
import com.retobackend.api.models.Employee;

import java.util.Locale;

public class Generate {

    private static final Faker FAKER = new Faker(new Locale("es"));

    public static Employee generateEmployee() {
        return new Employee(
                FAKER.name().firstName(),
                String.valueOf(FAKER.number().numberBetween(1000, 10000)),
                String.valueOf(FAKER.number().numberBetween(18, 40))
        );
    }

}
