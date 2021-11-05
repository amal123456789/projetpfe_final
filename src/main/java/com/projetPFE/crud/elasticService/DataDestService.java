package com.projetPFE.crud.elasticService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetPFE.crud.RepositoryElastic.DataDestinationRepoElastic;
import com.projetPFE.crud.model.DataDestinationModel;
import com.projetPFE.crud.model.DataSourceModel;
@Service
public class DataDestService {

	@Autowired
	DataDestinationRepoElastic repo;
	
	public String updateDS(DataDestinationModel data) {
		try {
			if (repo.existsById(data.getIdDestination())) {
				repo.save(data);
				return "data updated successfully.";
			} else {
				return "data does not exist.";
			}
		}catch (Exception e) {
			throw e;
		}
	}
	public String removeData(DataDestinationModel data) {
		try {
			if (repo.existsById(data.getIdDestination())) {
				repo.delete(data);
				return "data deleted successfully.";
			} else {
				return "data does not exist.";
			}
		}catch (Exception e) {
			throw e;
		}
	}
	
}
