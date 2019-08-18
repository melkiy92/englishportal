package com.englishportal.core.repositories;

import com.englishportal.core.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository <User, Long> {

    User getById(Long id);

}
