package com.ejemplo.demojpa;

import com.ejemplo.demojpa.controller.UserRepository;
import com.ejemplo.demojpa.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemojpaApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    private UserRepository userRepository;
    @Test
    public void findAllUsers() {
        List<User> users = userRepository.findAll();
        assertNotNull(users);
        assertTrue(!users.isEmpty());
    }
    @Test
    public void findUserById() {
        Optional<User> user = userRepository.findById(1);
        assertNotNull(user.get());
    }
    @Test
    public void createUser() {
        User user = new User("Paul", "paula@gmail123.com");
        User savedUser = userRepository.save(user);
        User newUser = userRepository.findById(savedUser.getId()).get();
        assertEquals("Paul", newUser.getName());
        assertEquals("paula@gmail123.com", newUser.getEmail());
    }
}

