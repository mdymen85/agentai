package com.mdymen.agentai.repository;

import com.mdymen.agentai.entity.UserValues;
import java.util.List;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersValuesRepository extends ListCrudRepository<UserValues, String> {

    List<UserValues> findByUserId(String userId);

}
