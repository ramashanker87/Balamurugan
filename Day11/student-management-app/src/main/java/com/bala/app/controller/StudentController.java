package com.bala.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {
private final StudentController studentController;
public StudentController(StudentController studentController) {
    this.studentController = studentController;
}

}
