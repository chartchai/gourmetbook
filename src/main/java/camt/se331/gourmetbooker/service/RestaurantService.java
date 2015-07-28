package camt.se331.gourmetbooker.service;

import camt.se331.gourmetbooker.entity.Restaurant;

import java.util.List;

/**
 * Created by Punjasin on 25/7/2558.
 */
public interface RestaurantService {
    Restaurant addshop(Restaurant res);
    Restaurant edit(Restaurant res);
    Restaurant delete(Long id);
    List<Restaurant> getShop();
    Restaurant getShopById(Long id);

}
