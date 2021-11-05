package com.projetPFE.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetPFE.crud.entity.Properties;
@Repository
public interface PropertiesRepository extends JpaRepository<Properties, Integer> {

public boolean existsBycodeProp(String codeProp);
	
	public boolean existsById(int idProperty);
	
}
