package com.sep.AuthorizationProviderServer.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.sep.AuthorizationProviderServer.model.Privilege;

public interface PrivilegeRepository extends JpaRepository<Privilege, Long>{

}
