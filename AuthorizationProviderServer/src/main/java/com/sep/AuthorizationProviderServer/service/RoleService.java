package com.sep.AuthorizationProviderServer.service;

import java.util.Collection;

import com.sep.AuthorizationProviderServer.model.Role;


public interface RoleService {
	
	Role save(Role role);
	Role getOne(Long id);
	Role updateRole(Role role);
	Collection<Role> getAllRoles();
	void deleteRole(Long id);
	Role addPrivilegeToRole(Long roleId,Long privilegeId);
	Role removePrivilegFromRole(Long roleId, Long privilegeId);
	
}
