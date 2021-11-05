package com.projetPFE.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projetPFE.crud.entity.UserN;
import com.projetPFE.crud.model.UserNModel;
import com.projetPFE.crud.service.UserNService;

@RestController
@CrossOrigin(origins = "*")
public class UserNController {
	@Autowired
	UserNService userService;

	@RequestMapping(value = "getusers", method = RequestMethod.GET)
	public List<UserNModel> getAllUSERSs() {
		return userService.getAllUsers();
	}

	@RequestMapping(value = "update-user", method = RequestMethod.PUT)
	public String updateUser(@RequestBody UserN user) {
		return userService.updateUser(user);
	}

	@RequestMapping(value = "delete-user", method = RequestMethod.DELETE)
	public String removeUser(@RequestBody UserN user) {
		return userService.removeUser(user);
	}

}
