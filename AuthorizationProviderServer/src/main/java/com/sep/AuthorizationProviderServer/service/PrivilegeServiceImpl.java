package com.sep.AuthorizationProviderServer.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sep.AuthorizationProviderServer.model.Privilege;
import com.sep.AuthorizationProviderServer.model.Role;
import com.sep.AuthorizationProviderServer.repository.PrivilegeRepository;
import com.sep.AuthorizationProviderServer.repository.RoleRepository;


@Service
public class PrivilegeServiceImpl implements PrivilegeService{

	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private PrivilegeRepository privilegeRepository;
	
	@Override
	public Privilege save(Privilege privilege) {
		return privilegeRepository.save(privilege);
	}
	
	@Override
	public Privilege updatePrivilege(Privilege privilege) {
		Privilege oldPrivilege = privilegeRepository.findOne(privilege.getId());
		oldPrivilege.setName(privilege.getName());
		return privilegeRepository.save(oldPrivilege);
	}

	@Override
	public Privilege getOne(Long id) {
		return privilegeRepository.findOne(id);
	}

	@Override
	public Collection<Privilege> getAllPrivileges() {
		return privilegeRepository.findAll();
	}

	@Override
	public void deletePrivilege(Long id) {
		privilegeRepository.delete(id);
	}

	@Override
	public ArrayList<String> getPrivilegesForRole(String roleName) {
		Role role = roleRepository.findRoleByName(roleName);
		
		return getPrivilegesName(privilegeRepository.findPrivilegesByRoles(role));
	}
	
	private ArrayList<String> getPrivilegesName(ArrayList<Privilege> privileges){
		ArrayList<String> retVal = new ArrayList<String>();
		for(Privilege p : privileges){
			retVal.add(p.getName());			
		}
		return retVal;
	}
	
}
