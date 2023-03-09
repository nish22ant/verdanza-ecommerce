package com.verdanza.admin.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.verdanza.common.entity.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {

}
