package com.bala.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
public class Request {
    @GetMapping("/Good")
    public String good() {
        return "Good";
    }
    @GetMapping("/Bad")
    public String bad() {
        return "Bad";
    }
}
