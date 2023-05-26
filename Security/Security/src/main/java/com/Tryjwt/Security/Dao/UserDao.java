package com.Tryjwt.Security.Dao;

import com.Tryjwt.Security.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDao extends JpaRepository<User,Integer> {

    Optional<User> findByEmail(String email);
}
