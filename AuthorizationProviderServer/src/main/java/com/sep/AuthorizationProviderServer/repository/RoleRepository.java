package com.sep.AuthorizationProviderServer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sep.AuthorizationProviderServer.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{

	Role findRoleByName(String role);
	
}
