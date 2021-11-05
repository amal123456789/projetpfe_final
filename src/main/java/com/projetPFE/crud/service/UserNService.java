package com.projetPFE.crud.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetPFE.crud.entity.RoleEnum;
import com.projetPFE.crud.entity.UserN;
import com.projetPFE.crud.model.UserNModel;
import com.projetPFE.crud.repository.UserNRepository;

@Service
public class UserNService {
	@Autowired
	UserNRepository usernrepository;

	public List<UserNModel> getAllUsers() {
		try {
			List<UserN> users = usernrepository.findAll();
			List<UserNModel> customUsers = new ArrayList<>();
			users.stream().forEach(e -> {
				UserNModel user = new UserNModel();
				BeanUtils.copyProperties(e, user);
				Iterator<RoleEnum> iterator = e.getRoles().iterator();
				user.setRole(iterator.hasNext() ? iterator.next().getName().name() : "");
				customUsers.add(user);
			});
			return customUsers;

		} catch (Exception e) {
			throw e;
		}

	}

	public String removeUser(UserN user) {
		try {
			if (usernrepository.existsByUsername(user.getUsername())) {
				usernrepository.delete(user);
				return "Employee deleted successfully.";
			} else {
				return "Employee does not exist.";
			}
		} catch (Exception e) {
			throw e;
		}
	}

	public String updateUser(UserN user) {
		try {
			if (usernrepository.existsById(user.getId())) {
				usernrepository.save(user);
				return "Employee updated successfully.";
			} else {
				return "Employee does not exist.";
			}
		} catch (Exception e) {
			throw e;
		}
	}
}
