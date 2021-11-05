package com.projetPFE.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetPFE.crud.entity.DataSource;
@Repository
public interface DataSourceRepository extends JpaRepository<DataSource, Integer> {

	
public boolean existsBySchemaUrl(String SchemaUrl);
	
	public boolean existsById(int id);

}
