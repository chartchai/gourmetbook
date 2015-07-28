package camt.se331.gourmetbooker.config;

import camt.se331.gourmetbooker.dao.RequestDao;
import camt.se331.gourmetbooker.entity.Request;
import camt.se331.gourmetbooker.entity.Restaurant;
import camt.se331.gourmetbooker.entity.Role;
import camt.se331.gourmetbooker.entity.User;
import camt.se331.gourmetbooker.repository.RoleRepository;
import camt.se331.gourmetbooker.repository.UserRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Created by Dto on 2/11/2015.
 */
@Component
@Profile("db.init")
public class DatabaseInitializationBean implements InitializingBean {

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRepository userRepository;
    @Autowired
    RequestDao requestDao;
    @Override
    public void afterPropertiesSet() throws Exception {

        // add User
        Role adminRole = new Role("admin");
        Role userRole = new Role("user");


        User admin = new User();

        admin.setUsername("admin");
        admin.setEmail("admin@yahoo.com");
        admin.setPassword("123456");
        Set<Role> roles = new HashSet<>();
        roles.add(adminRole);
        admin.setRoles(roles);

        User user = new User();

        user.setUsername("lula");
        user.setEmail("test@gmail.com");
        user.setAddress("Thailand");
        user.setFirstname("Jane");
        user.setSurname("Doe");
        user.setTel("080987654");
        user.setPassword("123456");
        user.setShop(new Restaurant("Test", 10, false, user));
        Request test=new Request(user);
        user.setRequest(test);
        requestDao.approve(test);

        Set<Role> roles2 = new HashSet<>();
        roles2.add(userRole);
        user.setRoles(roles2);
        userRepository.save(admin);
        userRepository.save(user);
        System.out.print(user.toString());
        admin.setRoles(roles);
        user.setRoles(roles2);
    }
}
