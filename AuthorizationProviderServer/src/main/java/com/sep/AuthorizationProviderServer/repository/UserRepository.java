package com.sep.AuthorizationProviderServer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sep.AuthorizationProviderServer.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findUserByEmail(String username);
	
}
