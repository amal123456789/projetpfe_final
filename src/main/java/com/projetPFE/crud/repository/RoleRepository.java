package com.projetPFE.crud.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetPFE.crud.entity.Role;
import com.projetPFE.crud.entity.RoleEnum;
@Repository
public interface RoleRepository extends JpaRepository<RoleEnum, Integer> {
	Optional<RoleEnum> findByName(Role name);
}
