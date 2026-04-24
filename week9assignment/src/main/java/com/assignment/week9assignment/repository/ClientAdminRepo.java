package com.assignment.week9assignment.repository;

import com.assignment.week9assignment.entity.ClientAdmin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientAdminRepo extends JpaRepository<ClientAdmin,Long> {
}
