package com.example.webservice.Rest.versioning;

public class personV2 {
    private Name name;

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public personV2() {

    }
    public personV2(Name name) {
        this.name = name;
    }
}
