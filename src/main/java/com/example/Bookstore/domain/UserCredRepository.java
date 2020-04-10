package com.example.Bookstore.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface UserCredRepository extends CrudRepository<UserCred, Long> {
	UserCred findByUsername(String username);
}
