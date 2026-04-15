package com.assignment.week9assignment.service;

import com.assignment.week9assignment.entity.Conference;
import com.assignment.week9assignment.entity.Session;
import com.assignment.week9assignment.repository.ConferenceRepo;
import com.assignment.week9assignment.repository.SessionRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SessionService {

    private final SessionRepo sessionRepo;
    private final ConferenceRepo conferenceRepo;

    public String addSession(Session session, Long conferenceId) {
         Conference conference = conferenceRepo.findById(conferenceId).orElseThrow();
         session.setConference(conference);
         sessionRepo.save(session);

         return "session add to the conference successfully";
    }

}
