package com.api.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.models.User;

public interface UserRepo extends JpaRepository<User, Integer>{

}
