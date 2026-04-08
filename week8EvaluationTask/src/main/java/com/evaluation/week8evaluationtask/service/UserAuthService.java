package com.evaluation.week8evaluationtask.service;

import com.evaluation.week8evaluationtask.dao.UserAuthDao;
import com.evaluation.week8evaluationtask.entity.UserAuth;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserAuthService implements UserDetailsService {

    private final UserAuthDao userAuthDao;
    private final PasswordEncoder passwordEncoder;


    public UserDetails save(UserAuth userAuth) {
        userAuth.setPassword(passwordEncoder.encode(userAuth.getPassword()));
        return userAuthDao.save(userAuth);
    }

    @Override
    public UserAuth loadUserByUsername(String username) throws UsernameNotFoundException {
        return userAuthDao.findByUsername(username);
    }
}
