package camt.se331.gourmetbooker.repository;

import camt.se331.gourmetbooker.entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Punjasin on 26/7/2558.
 */
public interface RequestRepository extends JpaRepository<Request,Long> {

}
