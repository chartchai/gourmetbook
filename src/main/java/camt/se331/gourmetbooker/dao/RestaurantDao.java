package camt.se331.gourmetbooker.dao;

import camt.se331.gourmetbooker.entity.Restaurant;

import java.util.List;

/**
 * Created by Punjasin on 25/7/2558.
 */
public interface RestaurantDao {
  Restaurant addshop(Restaurant res);
    Restaurant edit(Restaurant res);
    Restaurant delete(Restaurant res);
    List<Restaurant> getShop();
    Restaurant getShopById(Long id);
}
