package com.foo.demo.startAndFilter;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloTest {

    @RequestMapping("/hello")
    public  String  first(){
        return  "hello world";
    }
}
