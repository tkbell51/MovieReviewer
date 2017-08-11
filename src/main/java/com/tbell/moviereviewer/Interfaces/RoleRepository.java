package com.tbell.moviereviewer.Interfaces;

import com.tbell.moviereviewer.models.Role;
import com.tbell.moviereviewer.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {

    Role findByName(String role_user);
}
