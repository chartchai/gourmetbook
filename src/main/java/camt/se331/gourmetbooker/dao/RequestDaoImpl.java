package camt.se331.gourmetbooker.dao;

import camt.se331.gourmetbooker.entity.Request;
import camt.se331.gourmetbooker.entity.Restaurant;
import camt.se331.gourmetbooker.entity.User;
import camt.se331.gourmetbooker.repository.RequestRepository;
import camt.se331.gourmetbooker.repository.RestaurantRepository;
import camt.se331.gourmetbooker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Punjasin on 26/7/2558.
 */
public class RequestDaoImpl implements RequestDao {
    @Autowired
    RequestRepository requestRepositoryu;
    @Autowired
    RestaurantRepository restaurantRepository;
    @Autowired
    UserRepository userRepository;
    @Override
    public Request add(Request request) {
        return requestRepositoryu.save(request);
    }

    @Override
    public List<Request> getall() {
        return requestRepositoryu.findAll();
    }

    @Override
    public Request delete(Request request) {
        User user;
        user=userRepository.getOne(request.getOwner().getId());
        user.setRequest(null);
        userRepository.save(user);
        requestRepositoryu.delete(request);
        request.setId(null);
        return request;
    }

    @Override
    public Request approve(Request request) {
        Restaurant shop=request.getOwner().getShop();
        shop.setApprove(true);
        User user;
        user=userRepository.getOne(request.getOwner().getId());
        user.setRequest(null);
        userRepository.save(user);
        restaurantRepository.save(shop);
        requestRepositoryu.delete(request);
                request.setId(null);
        return request;
    }

    @Override
    public Request getone(Long id) {
        return requestRepositoryu.getOne(id);
    }

    @Override
    public Request edit(Request request) {
        return requestRepositoryu.save(request);
    }
}
