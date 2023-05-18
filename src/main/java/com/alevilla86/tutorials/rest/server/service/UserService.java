package com.alevilla86.tutorials.rest.server.service;

import com.alevilla86.tutorials.rest.server.dto.UserDto;
import com.alevilla86.tutorials.rest.server.initializer.UserInitializer;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author alejandro
 */
@Service
public class UserService {
    
    @Autowired
    private UserInitializer userDao;
    
    public List<UserDto> getAllUsers() {
        
        return userDao.getAllUsers();
    }
    
    public UserDto getUserByPhone(String phone) {
        
        List<UserDto> allUsers = getAllUsers();
        
        for (UserDto user : allUsers) {
            
            if (user.getPhone() == null) {
                continue;
            }
            
            //Aqui sabemos que el usuario tiene telefono.
            if (user.getPhone().equals(phone)) {
                return user;
            }
        }
        
        return null;
    }
    
    public UserDto createUser(UserDto user) throws Exception {
        
        if (user.getPhone() == null) {
            throw new Exception("Falta el telefono del usuario");
        }
        
        userDao.getAllUsers().add(user);
        
        return user;
    }
    
    public UserDto updateUser(String phone, UserDto updatedUser) throws Exception {
        
        if (phone == null) {
            throw new Exception("Falta el identificador del usuario");
        }
        
        if (updatedUser.getPhone() == null) {
            throw new Exception("Falta el telefono del usuario");
        }
        
        UserDto existingUser = getUserByPhone(phone);
        
        existingUser = updatedUser;
        
        return existingUser;
    }
    
    public UserDto updateUserLastName(String phone, String newLastName) {
        
        return null;
    }
    
    public void deleteUser(String phone) {
        
        List<UserDto> allUsers = getAllUsers();
        
        for (Iterator iterator = allUsers.iterator(); iterator.hasNext();) {
            
            UserDto user = (UserDto) iterator.next();
            
            if (user.getPhone().equals(phone)) {
                iterator.remove();
            }
        }
    }
}
