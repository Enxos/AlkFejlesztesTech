package com.futoverseny.beadando;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BeadandoController {
    
    @RequestMapping("/hello")
    public String hello(){
        return "Hello World";
    }

}
