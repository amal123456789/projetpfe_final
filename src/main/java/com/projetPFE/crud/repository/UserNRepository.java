package com.projetPFE.crud.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetPFE.crud.entity.UserN;
@Repository
public interface UserNRepository extends JpaRepository<UserN, Long> {
	Optional<UserN> findByUsername(String username);

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);

}
