package com.sep.AuthorizationProviderServer.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sep.AuthorizationProviderServer.model.Privilege;
import com.sep.AuthorizationProviderServer.repository.PrivilegeRepository;


@Service
public class PrivilegeServiceImpl implements PrivilegeService{

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
	
}
