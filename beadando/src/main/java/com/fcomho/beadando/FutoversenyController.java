package com.fcomho.futoverseny;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FutoversenyController {
    
    @RequestMapping("/hello")
    public String hello(){
        return "Hello World";
    }

}
