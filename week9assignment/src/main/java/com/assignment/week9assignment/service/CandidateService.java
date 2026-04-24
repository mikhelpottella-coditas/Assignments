package com.assignment.week9assignment.service;

import com.assignment.week9assignment.entity.Candidate;
import com.assignment.week9assignment.entity.Conference;
import com.assignment.week9assignment.entity.Session;
import com.assignment.week9assignment.repository.CandidateRepo;
import com.assignment.week9assignment.repository.ConferenceRepo;
import com.assignment.week9assignment.repository.SessionRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CandidateService {

    private final ConferenceRepo conferenceRepo;
    private final SessionRepo sessionRepo;
    private final CandidateRepo candidateRepo;

    public List<Conference> getAllConference() {
        return conferenceRepo.findAll();
    }

    public String enrollSession(Long candidateId, Long sessionId) {
        Candidate candidate = candidateRepo.findById(candidateId).orElseThrow();
        Session session= sessionRepo.findById(sessionId).orElseThrow();

        List<Session> sList = new ArrayList<>(Arrays.asList(session));
        candidate.setSessionList(sList);

        List<Candidate> cList = new ArrayList<>(Arrays.asList(candidate));
        session.setCandidateList(cList);

        candidateRepo.save(candidate);
        sessionRepo.save(session);

        return "enrolled to the session successfully";
    }

    public String showQR(String qr, Long sessionId) {

        System.out.println(">>>>"+qr);
        Session session = sessionRepo.findById(sessionId).orElseThrow();

        if(qr.startsWith("\"QR:")){
            if(session.getAttendance()==null){
                session.setAttendance(1L);
            }else {
                session.setAttendance(session.getAttendance() + 1);
            }
            return "attendance added";
        }
        else {
            System.out.println("why ");
            throw new RuntimeException();
        }
    }
}
