package camt.se331.gourmetbooker.repository;

import camt.se331.gourmetbooker.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Punjasin on 25/7/2558.
 */
public interface RestaurantRepository extends JpaRepository<Restaurant,Long> {
    public List<Restaurant> findByApproveTrue();
    public List<Restaurant> findByName(String name);
}
