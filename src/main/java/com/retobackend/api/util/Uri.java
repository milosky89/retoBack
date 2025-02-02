package com.retobackend.api.util;

public enum Uri {

    GET_ALL_EMPLOYEE("/api/v1/employees"),
    GET_EMPLOYEE_ID("/api/v1/employee/"),
    CREATE_EMPLOYEE("/api/v1/create"),
    DELETE_EMPLOYEE("/api/v1/delete/");

    private String uri;

    Uri(String uri){ this.uri = uri;}

    public String getUri(){ return uri;}

    public String withId(String id) {
        return this.uri + id;
    }
}
