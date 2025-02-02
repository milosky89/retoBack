package com.retobackend.api.models;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Employee {

    public String name;
    public String salary;

    public String age;

    public Employee(String name, String salary, String age) {
        this.name = name;
        this.salary = salary;
        this.age = age;
    }

    public Employee(String salary, String age) {
        this.salary = salary;
        this.age = age;
    }
}
