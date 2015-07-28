package camt.se331.gourmetbooker.dao;

import camt.se331.gourmetbooker.entity.Restaurant;
import camt.se331.gourmetbooker.entity.User;
import camt.se331.gourmetbooker.repository.RestaurantRepository;
import camt.se331.gourmetbooker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Punjasin on 25/7/2558.
 */
@Repository
public class RestaurantDaoImpl implements RestaurantDao {

    @Autowired
    RestaurantRepository restaurantRepository;
    @Autowired
    UserRepository userrepository;
    @Override
    public Restaurant addshop(Restaurant res) {
        return restaurantRepository.save(res);
    }

    @Override
    public Restaurant edit(Restaurant res) {
        return restaurantRepository.save(res);
    }

    @Override
    public Restaurant delete(Restaurant res) {
        User user=userrepository.getOne(res.getOwner().getId());
        user.setShop(null);
        userrepository.save(user);
        restaurantRepository.delete(res);
        res.setId(null);
        return res;
    }

    @Override
    public List<Restaurant> getShop() {
        return restaurantRepository.findByApproveTrue();
    }

    @Override
    public Restaurant getShopById(Long id) {
        return restaurantRepository.getOne(id);
    }
}
