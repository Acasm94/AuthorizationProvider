package com.sep.AuthorizationProviderServer.service;

import java.util.Collection;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.sep.AuthorizationProviderServer.model.User;


public interface UserService extends UserDetailsService {

	User createUser(User user);
	User getUser(String username);
	User getUser(Long id);
	Collection<User> getAllUsers();
	void deleteUser(Long userId);
	User addRoleToUser(Long userId, Long roleId);
	User removeRoleFromUser(Long userId, Long roleId);
	
}
