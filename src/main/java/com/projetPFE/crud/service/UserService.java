package com.projetPFE.crud.service;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetPFE.crud.entity.User;
import com.projetPFE.crud.model.UserModel;
import com.projetPFE.crud.repository.UserRepository;



@Service
public class UserService {
	@Autowired
	UserRepository userrepository;
	 public List<UserModel> getAllUsers(){
		 try {
			 List<User> users = userrepository.findAll();
			 List<UserModel> customUsers = new ArrayList<>();
			 users.stream().forEach(e -> {
				 UserModel user = new UserModel();
				 BeanUtils.copyProperties(e, user);
				 customUsers.add(user);
			 });
			 return customUsers;
			 
		 }catch(Exception e) {
			 throw e;
		 }
		 
	 }
	 
	 public String addUser(User user) {
			try {
				if (!userrepository.existsByLastName(user.getLastName())) {
					userrepository.save(user);
					return "Employee added successfully";
				}else {
					return "This employee already exists in the database.";
				}
			}catch (Exception e) {
				throw e;
			}
		}
		
		public String removeUser(User user) {
			try {
				if (userrepository.existsByLastName(user.getLastName())) {
					userrepository.delete(user);
					return "Employee deleted successfully.";
				} else {
					return "Employee does not exist.";
				}
			}catch (Exception e) {
				throw e;
			}
		}
		
		public String updateUser(User user) {
			try {
				if (userrepository.existsById(user.getId())) {
					userrepository.save(user);
					return "Employee updated successfully.";
				} else {
					return "Employee does not exist.";
				}
			}catch (Exception e) {
				throw e;
			}
		} 
	 
	 

}
