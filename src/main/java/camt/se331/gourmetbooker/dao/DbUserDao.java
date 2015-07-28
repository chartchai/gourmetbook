package camt.se331.gourmetbooker.dao;


import camt.se331.gourmetbooker.entity.User;
import camt.se331.gourmetbooker.repository.RequestRepository;
import camt.se331.gourmetbooker.repository.RestaurantRepository;
import camt.se331.gourmetbooker.repository.RoleRepository;
import camt.se331.gourmetbooker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by P-OniSawa on 14/5/2558.
 */

@Repository
public class DbUserDao implements UserDao {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    RestaurantRepository restaurantRepository;
    @Autowired
    RequestRepository requestRepositoryu;
    @Override
    public User addUser(User User) {
        User.getRoles().add(roleRepository.findOne(2L));
        return userRepository.save(User);
    }

    @Override
    public User editUser(User user) {
        if(user.getShop()!=null){
            restaurantRepository.save(user.getShop());
        }
        if(user.getRequest()!=null){
            requestRepositoryu.save(user.getRequest());
        }
        return userRepository.save(user);
    }

    @Override
    public User findByUsername(String name) {
        return userRepository.findByUsername(name);
    }


}
