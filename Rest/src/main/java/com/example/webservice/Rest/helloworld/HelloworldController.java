package com.example.webservice.Rest.helloworld;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloworldController {

    @RequestMapping(method= RequestMethod.GET,path="/welcome")
    public String welcome()
    {
        return "Welcome to spring boot";
    }

    @GetMapping(path="/welcome/path-variable/{name}")
    public String welcome(@PathVariable String name)
    {
        return "welcome "+name;
    }
}

