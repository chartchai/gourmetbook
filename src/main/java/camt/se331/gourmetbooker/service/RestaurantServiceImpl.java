package camt.se331.gourmetbooker.service;

import camt.se331.gourmetbooker.dao.RestaurantDao;
import camt.se331.gourmetbooker.entity.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Punjasin on 25/7/2558.
 */
@Service
public class RestaurantServiceImpl implements RestaurantService {
    @Autowired
    RestaurantDao restaurantDao;
    @Override
    public Restaurant addshop(Restaurant res) {
        return restaurantDao.addshop(res);
    }

    @Override
    public Restaurant edit(Restaurant res) {
        return restaurantDao.edit(res);
    }

    @Override
    public Restaurant delete(Long res) {
        Restaurant shop=restaurantDao.getShopById(res);
        return restaurantDao.delete(shop);
    }

    @Override
    public List<Restaurant> getShop() {
        return restaurantDao.getShop();
    }

    @Override
    public Restaurant getShopById(Long id) {
        return restaurantDao.getShopById(id);
    }
}
