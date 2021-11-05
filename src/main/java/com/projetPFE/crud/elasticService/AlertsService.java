package com.projetPFE.crud.elasticService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetPFE.crud.RepositoryElastic.AlertsElasticRepo;
import com.projetPFE.crud.model.AlertsModel;


@Service
public class AlertsService {
	@Autowired
	AlertsElasticRepo repo;
	
	
	public String updatelogs(AlertsModel dataSource) {
		try {
			if (repo.existsById(dataSource.getId())) {
				repo.save(dataSource);
				return "data updated successfully.";
			} else {
				return "data does not exist.";
			}
		}catch (Exception e) {
			throw e;
		}
	}
	public String removeDatalogs(AlertsModel dataSource) {
		try {
			if (repo.existsById(dataSource.getId())) {
				repo.delete(dataSource);
				return "data deleted successfully.";
			} else {
				return "data does not exist.";
			}
		}catch (Exception e) {
			throw e;
		}
	}



}
