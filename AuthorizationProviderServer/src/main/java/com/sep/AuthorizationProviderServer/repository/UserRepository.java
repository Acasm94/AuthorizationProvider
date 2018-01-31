package com.sep.AuthorizationProviderServer.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sep.AuthorizationProviderServer.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findUserByEmail(String username);
	User findUserById(Long id);
	
	@Query("select u from User as u join u.roles as r where r.id=?1")
	Set<User> findUsers(Long roleId);
}
