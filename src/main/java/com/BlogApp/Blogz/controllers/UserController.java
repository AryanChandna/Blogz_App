package com.BlogApp.Blogz.controllers;

import com.BlogApp.Blogz.payloads.UserDTO;
import com.BlogApp.Blogz.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    //POST-create user
    @PostMapping("/")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDto){

        UserDTO createUserDto = this.userService.createUser(userDto);
        return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
    }

    //PUT-update user

    //DELETE-delete user

    //GET-user fetch

}
