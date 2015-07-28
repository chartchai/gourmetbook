package camt.se331.gourmetbooker.service;

import camt.se331.gourmetbooker.dao.RequestDao;
import camt.se331.gourmetbooker.entity.Request;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Punjasin on 26/7/2558.
 */
public class RequestServiceImpl implements RequestService {
@Autowired
    RequestDao requestDao;
    @Override
    public List<Request> getRequest() {
        return requestDao.getall();
    }

    @Override
    public Request getRequestById(Long id) {
        return requestDao.getone(id);
    }

    @Override
    public Request edit(Request request) {
        return requestDao.edit(request);
    }

    @Override
    public Request delete(Request request) {
        return requestDao.delete(request);
    }

}
