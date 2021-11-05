package com.projetPFE.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projetPFE.crud.entity.User;
import com.projetPFE.crud.model.UserModel;
import com.projetPFE.crud.service.UserService;

@RestController
@CrossOrigin(origins = "*")
public class UserController {
	@Autowired
	UserService userService;
	
	
/*@GetMapping("trouve")
public Iterable<User> getListUsersss(){
		return userService.getAllUsers();
	}*/
	
	@RequestMapping(value = "getallusers", method = RequestMethod.GET)
	public List<UserModel> getAllUSERSs(){
		return userService.getAllUsers();
	}
	
	@RequestMapping(value = "adduser", method = RequestMethod.POST)
	public String addUser(@RequestBody User user) {
		return userService.addUser(user);
	}
	
	@RequestMapping(value = "updateuser", method = RequestMethod.PUT)
	public String updateUser(@RequestBody User user) {
		return userService.updateUser(user);
	}
	
	@RequestMapping(value = "deleteuser", method = RequestMethod.DELETE)
	public String removeUser(@RequestBody User user) {
		return userService.removeUser(user);
	}
	
}