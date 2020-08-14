package com.eclat.solutions.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
public class CourseController {
    @GetMapping("v1/courses")//Should be accessible by user only
    public List<String> allCourses() {
        return List.of("English", "Urdu", "Science");
    }
}
