package com.assignment.week9assignment.controller;

import com.assignment.week9assignment.entity.Conference;
import com.assignment.week9assignment.service.CandidateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/candidateWrok")
public class CandidateWorkController { // allowed by everyone

    private final CandidateService candidateService;

    @GetMapping("/getAllConference")
    public List<Conference> getAllConference(){
        return candidateService.getAllConference();
    }

    @PatchMapping("/enrollSession/{candidateId}/{sessionId}")
    public String enrollSession(@PathVariable Long candidateId,@PathVariable Long sessionId){
        return candidateService.enrollSession(candidateId,sessionId);
    }

    @PostMapping("/showQR/{sessionId}")
    public String showQR(@RequestBody String QR,@PathVariable Long sessionId){
        return candidateService.showQR(QR,sessionId);
    }

}
