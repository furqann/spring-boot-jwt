package com.eclat.solutions.controller;

import com.eclat.solutions.dto.UserDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @GetMapping("v1/users")//Should be accessible by Admin
    public List<UserDto> findAll(){
        return List.of(new UserDto("super@eclat.co","super_user"),
                new UserDto("user@eclat.co","u_user"));
    }
}
