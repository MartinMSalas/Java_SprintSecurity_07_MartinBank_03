package com.martin.egg.martinbank3.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/welcome") // http://localhost:8081/api/welcome
public class WelcomeController {

    @GetMapping("/hellopublic") // http://localhost:8081/api/welcome/hellopublic
    public ResponseEntity<String> hello(){
        return new ResponseEntity<>("Hello World", HttpStatus.OK);
    }
    @GetMapping("/helloprotected") // http://localhost:8081/api/welcome/helloprotected
    public ResponseEntity<String> sayHelloProtected(){
        return new ResponseEntity<>("Hello World Protected", HttpStatus.OK);
    }
    @GetMapping("/hellouser")
    public ResponseEntity<String> sayHelloUser(){
        return new ResponseEntity<>("Hello World User", HttpStatus.OK);
    }
    @GetMapping("/helloadmin")
    public ResponseEntity<String> sayHelloAdmin(){
        return new ResponseEntity<>("Hello World Admin", HttpStatus.OK);
    }
}
