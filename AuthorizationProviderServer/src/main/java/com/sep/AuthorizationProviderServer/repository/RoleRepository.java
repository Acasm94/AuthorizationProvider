package com.sep.AuthorizationProviderServer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sep.AuthorizationProviderServer.model.Role;


public interface RoleRepository extends JpaRepository<Role, Long>{
	
}
