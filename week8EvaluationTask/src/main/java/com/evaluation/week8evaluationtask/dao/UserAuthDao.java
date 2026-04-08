package com.evaluation.week8evaluationtask.dao;

import com.evaluation.week8evaluationtask.entity.UserAuth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAuthDao extends JpaRepository<UserAuth,Long> {

    public UserAuth findByUsername(String username);

}
