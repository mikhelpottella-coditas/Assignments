package com.practice.week9practice.service;

import com.practice.week9practice.dao.UserRepo;
import com.practice.week9practice.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;


    public List<User> getAllUsers() {
        return userRepo.findAll();
    }


    public User addUser(User user) {
        return userRepo.save(user);
    }


    public User getById(Long id) {
        return userRepo.findById(id).orElseThrow(()-> new RuntimeException("not found"));
    }

    @Transactional
    public User updateById(Long id, User user) {
        User inUser = getById(id);
        if(user.getName()!=null) inUser.setName(user.getName());
        if(user.getWork()!=null) inUser.setWork(user.getWork());
        userRepo.save(inUser);
        return inUser;
    }

    public void deleteById(Long id) {
        User user = getById(id);
        userRepo.delete(user);
    }
}
