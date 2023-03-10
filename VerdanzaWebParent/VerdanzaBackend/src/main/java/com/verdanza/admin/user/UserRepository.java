package com.verdanza.admin.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.verdanza.common.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

}
