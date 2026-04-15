package com.assignment.week9assignment.controller;

import com.assignment.week9assignment.entity.Session;
import com.assignment.week9assignment.service.SessionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/clientAdminWork")
public class ClientAdminWorkController {

    private final SessionService sessionService;

    @PostMapping("/addSession/forConference/{conferenceId}")
    public String addSession(@RequestBody Session session, @PathVariable Long conferenceId){
        return sessionService.addSession(session,conferenceId);
    }


}
