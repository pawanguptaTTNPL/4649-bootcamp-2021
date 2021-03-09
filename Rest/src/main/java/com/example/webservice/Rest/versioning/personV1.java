package com.example.webservice.Rest.versioning;

public class personV1 {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public personV1()
    {
        super();
    }

    public personV1(String name) {
        this.name = name;
    }
}
