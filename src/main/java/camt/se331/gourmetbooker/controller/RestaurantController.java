package camt.se331.gourmetbooker.controller;

import camt.se331.gourmetbooker.entity.Restaurant;
import camt.se331.gourmetbooker.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Punjasin on 25/7/2558.
 */


@RestController
@RequestMapping("/")

public class RestaurantController {
    @Autowired
    RestaurantService restaurantServices;
    @RequestMapping(value = "shop",method = RequestMethod.GET)
    public List<Restaurant> list(){
        return restaurantServices.getShop();
    }
}
