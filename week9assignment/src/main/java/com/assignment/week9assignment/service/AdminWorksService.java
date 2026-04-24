package com.assignment.week9assignment.service;

import com.assignment.week9assignment.entity.Candidate;
import com.assignment.week9assignment.entity.ClientAdmin;
import com.assignment.week9assignment.entity.Conference;
import com.assignment.week9assignment.enums.Role;
import com.assignment.week9assignment.repository.CandidateRepo;
import com.assignment.week9assignment.repository.ClientAdminRepo;
import com.assignment.week9assignment.repository.ConferenceRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminWorksService {

    private final ClientAdminRepo clientAdminRepo;
    private final CandidateRepo candidateRepo;
    private final ConferenceRepo conferenceRepo;
    private final PasswordEncoder passwordEncoder;

    public String createClientAdmin(ClientAdmin clientAdmin) {
        clientAdmin.getUser().setRole(Role.CLIENT_ADMIN);
        clientAdmin.getUser().setPassword(passwordEncoder.encode(clientAdmin.getUser().getPassword()));
        clientAdminRepo.save(clientAdmin);
        return "Client Admin created Successfully";
    }

    public String createCandidate(Candidate candidate) {
        candidate.getUser().setRole(Role.CANDIDATE);
        candidate.getUser().setPassword(passwordEncoder.encode(candidate.getUser().getPassword()));
        candidateRepo.save(candidate);
        return "candidate is created successfully";
    }

    public String createConference(Conference conference) {
        conference.getSessions().forEach(s->{
            s.setConference(conference);
        });
        conferenceRepo.save(conference);
        return "conference is created!!";
    }

    public String deleteConference(Long id) {
        Conference conference = conferenceRepo.findById(id).orElseThrow();
        conference.getSessions().forEach(s->s.setConference(null));
        conferenceRepo.delete(conference);
        return "hey conference deleted!!";
    }
}
