package com.evaluation.week8evaluationtask.service;

import com.evaluation.week8evaluationtask.dao.ManagerDao;
import com.evaluation.week8evaluationtask.entity.Manager;
import com.evaluation.week8evaluationtask.enums.Roles;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ManagerService {

    private final ManagerDao managerDao;
    private final PasswordEncoder passwordEncoder;

    public Manager registerManager(Manager manager) {
        manager.getUserAuth().setRole(Roles.MANAGER);
        manager.getUserAuth().setPassword(passwordEncoder.encode(manager.getUserAuth().getPassword()));
        return managerDao.save(manager);
    }
}
