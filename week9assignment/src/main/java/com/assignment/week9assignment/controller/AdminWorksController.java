package com.assignment.week9assignment.controller;

import com.assignment.week9assignment.entity.Candidate;
import com.assignment.week9assignment.entity.ClientAdmin;
import com.assignment.week9assignment.entity.Conference;
import com.assignment.week9assignment.service.AdminWorksService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/adminWork")
public class AdminWorksController {

    private final AdminWorksService adminWorksService;


//Responsible for creating Client Admins, Users, and managing Conferences

    @PostMapping("/create/clientAdmin")
    public String createClientAdmin(@RequestBody ClientAdmin clientAdmin){
        return adminWorksService.createClientAdmin(clientAdmin);
    }

    @PostMapping("/create/candidate")
    public String createCandidate(@RequestBody Candidate candidate){
        return adminWorksService.createCandidate(candidate);
    }


    @PostMapping("/create/conference")
    public String createConference(@RequestBody Conference conference){
        return adminWorksService.createConference(conference);
    }

    @DeleteMapping("/deleteConference/{id}")
    public String deleteConference(@PathVariable Long id){
        return adminWorksService.deleteConference(id);
    }

}
