package com.practise.relationmapping.dao;

import com.practise.relationmapping.entity.UserAuth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserAuthDao extends JpaRepository<UserAuth,Long> {

    Optional<UserAuth> findByUserName(String userName);

}
