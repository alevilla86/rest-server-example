package com.alevilla86.tutorials.rest.server.controller;

import jakarta.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author alejandro
 */
@RestController
@RequestMapping("users")
public class UserController {
    
    private static final String user1 = "Alejandro Villalobos";
    private static final String user2 = "Ana Moraga";
    
    @GetMapping
    public List<String> getUsers(HttpServletRequest request) {
        
        String userToken = request.getHeader("user-token");
        
        if (userToken == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
        
        List<String> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        
        return users;
    }
}
