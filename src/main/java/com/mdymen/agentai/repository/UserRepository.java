package com.mdymen.agentai.repository;

import com.mdymen.agentai.entity.User;
import java.util.Optional;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends ListCrudRepository<User, Long> {

    Optional<User> findByFirstName(String name);

}
