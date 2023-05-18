package com.alevilla86.tutorials.rest.server.initializer;

import com.alevilla86.tutorials.rest.server.dto.UserDto;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 *
 * @author alejandro
 */
@Component
public class UserInitializer implements InitializingBean {
    
    private List<UserDto> users = new ArrayList<>();

    @Override
    public void afterPropertiesSet() throws Exception {
        createUsers();
    }
    
    private void createUsers() {
        
        UserDto ale = new UserDto("Alejandro", "Villalobos", "alevilla86@hotmail.com", "+50688100452", 37);
        UserDto ana = new UserDto("Ana", "Moraga", "amoraga@hotmail.com", "+89907865", 26);
        UserDto maria = new UserDto("Maria Laura", "Hernandez", "mmlhhfg@hotmail.com", "+50688100452", 37);
        UserDto roger = new UserDto("Roger", "Rojas", "rrjj@hotmail.com", "87654098", 20);
        UserDto claudio = new UserDto("Claudio", "Aguirre", "caguirre@hotmail.com", "88668890", 89);
        
        users.add(ale);
        users.add(ana);
        users.add(maria);
        users.add(roger);
        users.add(claudio);
    }
    
    public List<UserDto> getAllUsers() {
        return users;
    }
    
}
