package com.sep.AuthorizationProviderServer.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sep.AuthorizationProviderServer.model.Permission;
import com.sep.AuthorizationProviderServer.model.User;
import com.sep.AuthorizationProviderServer.service.UserService;


@RestController
@RequestMapping("/users")
public class UserController {

	private final UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/{userId}")
	@ResponseBody
	@Permission(permissionName = "readUser")
	public User getUser(@PathVariable("userId") Long userId){
		return userService.getUser(userId);
	}
	
	@GetMapping
	@ResponseBody
	@Permission(permissionName = "readUsers")
	public Collection<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@PostMapping("addRoleToUser/{userId}/{roleId}")
	@ResponseBody
	@Permission(permissionName = "addRoleToUser")
	public User addRoleToUser(@PathVariable("userId") Long userId,
							  @PathVariable("roleId") Long roleId){
		return userService.addRoleToUser(userId, roleId);
	}
	
	@DeleteMapping("removeRoleToUser/{userId}/{roleId}")
	@ResponseBody
	@Permission(permissionName = "removeRoleFromUser")
	public User removeRoleFromUser(@PathVariable("userId") Long userId,
							  @PathVariable("roleId") Long roleId){
		return userService.removeRoleFromUser(userId, roleId);
	}
	
	@GetMapping("getContactInfoForNotification")
	@ResponseBody
	@Permission(permissionName = "getContactInfoForNotification")
	public List<String> getContactInfoForNotification(@RequestParam(value="salespersonId", required=false) Long id, 
			@RequestParam(value="roleId", required=true) List<Long> roleId){
		
		Set<User> allUsers = new HashSet<User>();
		
		for(Long role : roleId){
			Set<User> users = userService.getContactInfoForNotification(id, role);
			allUsers.addAll(users);
		}
		
		List<String> contactInfo = new ArrayList<String>();

		for(User u : allUsers) {
			if(u != null) {
				contactInfo.add(u.getEmail());
			}
		}
		
		return contactInfo;
	}
}
