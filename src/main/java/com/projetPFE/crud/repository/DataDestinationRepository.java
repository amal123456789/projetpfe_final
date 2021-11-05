package com.projetPFE.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetPFE.crud.entity.DataDestination;
@Repository
public interface DataDestinationRepository extends JpaRepository<DataDestination, Integer> {
	

	
	public boolean existsById(int id);

	public boolean existsByipAdressDestination(String ipAdressDestination);

}
