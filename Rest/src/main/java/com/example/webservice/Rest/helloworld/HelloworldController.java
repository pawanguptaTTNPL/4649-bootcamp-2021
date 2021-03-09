package com.example.webservice.Rest.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
public class HelloworldController {
    @Autowired
    private MessageSource messageSource;

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
    @GetMapping(path="/hello-world-internationalized/{name}")
    public String helloWorldInternationalized(
            @RequestHeader(name="Accept-Language",required = false)Locale locale,@PathVariable String name)
    {
        final String[] params = new String[]{name};
        return messageSource.getMessage("good.morning.message",params,locale);
    }
//    @GetMapping(path="/hello-world-internationalized/{name}")
//    public String helloWorldInternationalized(@RequestHeader(name="Accept-Language",required = false)Locale locale,@PathVariable String name)
//    {
//
//        return messageSource.getMessage("good.morning.message ",new Object[] {"Paul Smith"},locale);
//    }

}

//messageSource.getMessage("l2",
//        new Object[] {"Paul Smith"}, Locale.GERMAN));