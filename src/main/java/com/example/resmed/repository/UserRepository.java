package com.example.resmed.repository;

import com.example.resmed.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByUserId(Long id);
    User findByEmailAndPassword(String email,String password);
}
