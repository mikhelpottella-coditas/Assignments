package com.assignment.week9assignment.repository;

import com.assignment.week9assignment.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateRepo extends JpaRepository<Candidate,Long> {
}
