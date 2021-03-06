package camt.se331.gourmetbooker.repository;


import camt.se331.gourmetbooker.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Dto on 4/19/2015.
 */
public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmail(String email);
    User findByUsername(String username);
    User findByEmailAndPassword(String email, String password);


}
