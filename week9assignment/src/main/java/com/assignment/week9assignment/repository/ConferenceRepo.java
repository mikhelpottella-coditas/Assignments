package com.assignment.week9assignment.repository;

import com.assignment.week9assignment.entity.Conference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConferenceRepo extends JpaRepository<Conference,Long> {
}
