package com.alevilla86.tutorials.rest.server.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author alejandro
 */
@RestController
@RequestMapping("/hello-world")
public class HelloWolrdController {
    
    @GetMapping
    public String helloWorld() {
        
        return "Hola Mundo! Bienvenidos a REST";
    }
    
    @GetMapping("user")
    public String helloWorldUser(@RequestParam(required = false, defaultValue = "-no se definio usuario") String username) {
        
        return "Hola " + username + " bienvenido a REST";
    }
    
    @GetMapping("user/v2")
    public String helloWorldUserRequiredUser(@RequestParam(required = false) String username) {
        
        if (username == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El nombre de usuario no esta presente en el request");
        }
        
        return "Hola " + username + " bienvenido a REST";
    }
    
    @GetMapping("user/v2/with-request")
    public String helloWorldUserRequiredUserWithRequest(
            HttpServletRequest request,
            @RequestParam(required = false) String username
    ) {
        
        String ip = request.getRemoteAddr();
        String method = request.getMethod();
        String userAgent = request.getHeader("User-Agent");
        String userAlias = request.getHeader("User-Alias");
        
        if (username == null && userAlias == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El nombre de usuario no esta presente en el request");
        } else if (username == null && userAlias != null) {
            username = userAlias;
        }
        
        return "Hola " + username + " bienvenido a REST. Nos esta llamando desde " + ip + ". Con un metodo: " + method + ". Y el user agent es: " + userAgent;
    }
}
