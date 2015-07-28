package camt.se331.gourmetbooker.service;

import camt.se331.gourmetbooker.entity.Request;

import java.util.List;

/**
 * Created by Punjasin on 26/7/2558.
 */
public interface RequestService {
    List<Request> getRequest();
    Request getRequestById(Long id);
    Request edit(Request request);
    Request delete(Request request);
}
