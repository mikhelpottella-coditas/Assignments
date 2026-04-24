package com.assignment.week9assignment.controller;

import com.assignment.week9assignment.entity.Admin;
import com.assignment.week9assignment.service.SuperAdminWorksService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/superAdminWork")
public class SuperAdminWorksController { // these endpoints are only accessed by SuperAdmin.

    private final SuperAdminWorksService service;




    @PostMapping("/create")
    public String createAdmin(@RequestBody Admin admin){
        return service.createAdmin(admin);
    }

    @DeleteMapping("/deleteAdmin/{id}")
    public String deleteAdmin(@PathVariable Long id){
        return service.deleteAdmin(id);
    }

}
