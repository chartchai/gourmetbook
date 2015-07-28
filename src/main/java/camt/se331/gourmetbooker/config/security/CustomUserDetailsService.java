package camt.se331.gourmetbooker.config.security;

import camt.se331.gourmetbooker.entity.User;
import camt.se331.gourmetbooker.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * Created by Dto on 4/19/2015.
 */
@Component
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserServiceImpl userService;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User User = userService.findByUserName(userName);
        if(User == null){
            throw new UsernameNotFoundException("User name" + userName + "not found");
        }
        return new SecurityUser(User);
    }
}
