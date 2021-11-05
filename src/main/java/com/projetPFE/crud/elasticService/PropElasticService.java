package com.projetPFE.crud.elasticService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetPFE.crud.RepositoryElastic.PropertiesRepoElastic;
import com.projetPFE.crud.model.DataSourceModel;
import com.projetPFE.crud.model.PropertiesModel;

@Service
public class PropElasticService {
	
	@Autowired
	PropertiesRepoElastic repo;
	public String updateDS(PropertiesModel prop) {
		try {
			if (repo.existsById(prop.getIdProperty())) {
				repo.save(prop);
				return "data updated successfully.";
			} else {
				return "data does not exist.";
			}
		}catch (Exception e) {
			throw e;
		}
	}
	public String removeData(PropertiesModel prop) {
		try {
			if (repo.existsById(prop.getIdProperty())) {
				repo.delete(prop);
				return "data deleted successfully.";
			} else {
				return "data does not exist.";
			}
		}catch (Exception e) {
			throw e;
		}
	}

}
