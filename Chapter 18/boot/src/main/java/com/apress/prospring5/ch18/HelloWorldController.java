package com.apress.prospring5.ch18;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @RequestMapping("/")
    public String helloWorld() {
        return "Hello world";
    }
}
