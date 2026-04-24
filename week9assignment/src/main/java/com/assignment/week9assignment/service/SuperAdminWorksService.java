package com.assignment.week9assignment.service;

import com.assignment.week9assignment.entity.Admin;
import com.assignment.week9assignment.enums.Role;
import com.assignment.week9assignment.repository.AdminRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SuperAdminWorksService {


    private final AdminRepo adminRepo;
    private final PasswordEncoder passwordEncoder;


    public String createAdmin(Admin admin) {
        admin.getUser().setRole(Role.ADMIN);
        admin.getUser().setPassword(passwordEncoder.encode(admin.getUser().getPassword()));
        adminRepo.save(admin);
        return "User saved successfully";
    }


    public String deleteAdmin(Long id) {
        Admin admin = adminRepo.findById(id).orElseThrow();
        adminRepo.delete(admin);

        return "Admin deleted Successfully";
    }
}
