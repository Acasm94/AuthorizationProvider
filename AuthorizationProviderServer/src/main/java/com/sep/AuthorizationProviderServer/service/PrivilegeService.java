package com.sep.AuthorizationProviderServer.service;

import java.util.ArrayList;
import java.util.Collection;

import com.sep.AuthorizationProviderServer.model.Privilege;


public interface PrivilegeService {
	
	Privilege save(Privilege privilege);
	Privilege updatePrivilege(Privilege privilege);
	Privilege getOne(Long id);
	Collection<Privilege> getAllPrivileges();
	void deletePrivilege(Long id);
	ArrayList<String> getPrivilegesForRole(String role);
	
}
