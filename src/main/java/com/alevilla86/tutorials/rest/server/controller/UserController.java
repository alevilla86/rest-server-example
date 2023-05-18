package com.alevilla86.tutorials.rest.server.controller;

import com.alevilla86.tutorials.rest.server.dto.UserDto;
import com.alevilla86.tutorials.rest.server.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    
    @Autowired
    private UserService userService;
    
    @GetMapping
    public List<UserDto> getUsers() {
        
        List<UserDto> users = userService.getAllUsers();
        
        System.out.println("La lista de usuarios contiene " + users.size() + " usuarios en total.");
        
        return users;
    }
    
    @GetMapping("{phone}")
    public UserDto getUserByPhone(@PathVariable("phone") String phoneNumber) {
        
        System.out.println("Estamos buscando el usuario con el telefono " + phoneNumber);
        
        UserDto user = userService.getUserByPhone(phoneNumber);
        
        if (user == null) {
            System.out.println("Ese usuario no existe");
            return user;
        }
        
        System.out.println("Encontramos un usauario con ese telefono: " + user.getEmail());
        
        return user;
    }
    
    @PostMapping
    public UserDto createUser(@RequestBody UserDto dto) {
        
        System.out.println("Estamos creando el usuario: " + dto.toString());
        
        try {
            
            UserDto user = userService.createUser(dto);
            
            System.out.println("El usuario fue creado con exito: " + dto.toString());
            
            return user;
            
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }
    
    @PutMapping("{phone}")
    public UserDto updateUser(@PathVariable String phone, @RequestBody UserDto dto) {
        
        System.out.println("Estamos actualizando el usuario: " + phone);
        
        try {
            
            UserDto updatedUser = userService.updateUser(phone, dto);
            
            return updatedUser;
            
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }
    
    @DeleteMapping("{phone}")
    public void deleteUser(@PathVariable String phone) {
        
        userService.deleteUser(phone);
    }
}
