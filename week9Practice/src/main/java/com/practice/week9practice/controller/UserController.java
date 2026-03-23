package com.practice.week9practice.controller;

import com.practice.week9practice.entity.User;
import com.practice.week9practice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService service;


    @GetMapping("/getAllUsers")
    public List<User> getAllUsers(){
        return service.getAllUsers();
    }

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user){
        return service.addUser(user);
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable Long id){
        return service.getById(id);
    }

    @PatchMapping("update/{id}")
    public User updateById(@PathVariable Long id,@RequestBody User user){
        return service.updateById(id,user);
    }

    @DeleteMapping("deleteById/{id}")
    public void deleteById(@PathVariable Long id){
        service.deleteById(id);
    }
}
