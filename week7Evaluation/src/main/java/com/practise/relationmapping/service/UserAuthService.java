package com.practise.relationmapping.service;

import com.practise.relationmapping.dao.UserAuthDao;
import com.practise.relationmapping.entity.UserAuth;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserAuthService implements UserDetailsService {

    private final UserAuthDao userAuthDao;

    public UserDetails save(UserAuth userAuth){
        return userAuthDao.save(userAuth);
    }

    @Override
    public UserAuth loadUserByUsername(String username) throws UsernameNotFoundException {
        return userAuthDao.findByUserName(username).orElseThrow(()->new RuntimeException("user not found"));
    }
}
