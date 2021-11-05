package com.projetPFE.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetPFE.crud.entity.SourceProperties;
@Repository
public interface SourcePropertiesRepository extends JpaRepository<SourceProperties, Integer> {

	
public boolean existsByValue(String value);
	
	public boolean existsById(int id);
	
}
