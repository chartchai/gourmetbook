package camt.se331.gourmetbooker.dao;

import camt.se331.gourmetbooker.entity.Request;

import java.util.List;

/**
 * Created by Punjasin on 26/7/2558.
 */
public interface RequestDao {
    Request add(Request request);
    List<Request> getall();
    Request delete(Request request);
    Request approve(Request request);
    Request getone(Long id);
    Request edit(Request request);
}
