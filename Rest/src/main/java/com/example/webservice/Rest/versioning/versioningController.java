package com.example.webservice.Rest.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class versioningController {


    //uri version
    @GetMapping("/v1/person")
    public personV1 PersonV1() {
        return new personV1("Pawan Gupta");
    }

    @GetMapping("/v2/person")
    public personV2 PersonV2() {
        return new personV2(new Name("Pawan", "Gupta"));
    }


//Request Parameter

    @GetMapping(value = "/person/param", params = "version=1")
    public personV1 paramV1() {
        return new personV1("Pawan Gupta");
    }

    @GetMapping(value = "/person/param", params = "version=2")
    public personV2 param2() {
        return new personV2(new Name("Pawan", "Gupta"));
    }

//
//header Versioning


    @GetMapping(value = "/person/header", headers = "X-API-VERSION=1")
    public personV1 headerV1() {
        return new personV1("Pawan Gupta");
    }

    @GetMapping(value = "/person/header", headers = "X-API-VERSION=2")
    public personV2 headerV2() {
        return new personV2(new Name("Pawan", "Gupta"));
    }

    // mime type versioning

    @GetMapping(value = "/person/produce", produces = "application/vnd.company.app-v1+json")
    public personV1 produceV1() {
        return new personV1("Pawan Gupta");
    }

    @GetMapping(value = "/person/produce", produces = "application/vnd.company.app-v2+json")
    public personV2 produceV2() {
        return new personV2(new Name("Pawan", "Gupta"));
    }

}
