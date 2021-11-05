package com.projetPFE.crud.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetPFE.crud.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	public boolean existsById(int id);

	public boolean existsByLastName(String lastName);
	Optional<User> findByUsername(String username);

	Boolean existsByUsername(String username);

	Boolean existsByMail(String email);
	

}
