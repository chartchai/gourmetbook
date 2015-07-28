package camt.se331.gourmetbooker.dao;


import camt.se331.gourmetbooker.entity.User;
import org.springframework.stereotype.Repository;

/**
 * Created by P-OniSawa on 14/5/2558.
 */
@Repository
public interface UserDao {
    User addUser(User User);
    User editUser(User user);
    User findByUsername(String name);

}
