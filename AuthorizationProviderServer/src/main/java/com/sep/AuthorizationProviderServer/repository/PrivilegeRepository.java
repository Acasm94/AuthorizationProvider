package com.sep.AuthorizationProviderServer.repository;


import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sep.AuthorizationProviderServer.model.Privilege;
import com.sep.AuthorizationProviderServer.model.Role;

@Repository
public interface PrivilegeRepository extends JpaRepository<Privilege, Long>{

	ArrayList<Privilege> findPrivilegesByRoles(Role role);

}
