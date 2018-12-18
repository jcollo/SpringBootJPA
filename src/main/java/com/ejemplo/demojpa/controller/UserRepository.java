package com.ejemplo.demojpa.controller;

import com.ejemplo.demojpa.domain.User;
//import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Integer> {
    
}
