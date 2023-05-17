package com.alevilla86.tutorials.rest.server.controller;

import com.alevilla86.tutorials.rest.server.dto.LoginDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author alejandro
 */
@RestController
@RequestMapping("login")
public class LoginController {
    
    @PostMapping
    public String login(
            @RequestBody LoginDto loginData
    ) {
        
        String token = loginData.getUsername() + loginData.getPassword();
        StringBuilder encryptedToken = new StringBuilder(token).reverse();
        
        return encryptedToken.toString();
    }
}


