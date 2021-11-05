package com.projetPFE.crud.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetPFE.crud.entity.Logs;
import com.projetPFE.crud.model.LogsModel;
@Repository
public interface LogsRepository extends JpaRepository<Logs, Integer> {
	public boolean existsByTYPE(String TYPE);
	
	public boolean existsById(int id);
	
	List<Logs> findByMETHODE(String methode);
	
}
