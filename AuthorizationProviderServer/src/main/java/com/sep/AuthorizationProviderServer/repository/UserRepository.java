package com.sep.AuthorizationProviderServer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sep.AuthorizationProviderServer.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findUserByEmail(String username);
	
}
