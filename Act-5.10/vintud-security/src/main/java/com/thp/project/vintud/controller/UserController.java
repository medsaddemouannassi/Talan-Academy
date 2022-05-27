package com.thp.project.vintud.controller;

import com.thp.project.vintud.dto.UserDto;
import com.thp.project.vintud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @Transactional
    @GetMapping(value = "/user")
    @ResponseBody
    public List<UserDto> all() {
        return userService.findAll();
    }

    @Transactional
    @PostMapping(value = "/user")
    public void addUser(@RequestBody UserDto user) {
        userService.addUser(user);
    }

    @Transactional
    @GetMapping(value = "/user/{userId}")
    @ResponseBody
    public UserDto getUser(@PathVariable int userId) {
        return userService.getUser(userId);
    }

    @Transactional
    @DeleteMapping(value = "/user/{userId}")
    public void delete(@PathVariable int userId) {
        userService.delete(userId);
    }
}
