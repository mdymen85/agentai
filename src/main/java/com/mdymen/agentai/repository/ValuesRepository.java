package com.mdymen.agentai.repository;

import com.mdymen.agentai.entity.Values;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ValuesRepository extends ListCrudRepository<Values, String> {

}
