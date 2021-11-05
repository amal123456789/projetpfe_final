package com.projetPFE.crud.elasticService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetPFE.crud.RepositoryElastic.SourcePropertyRepoElastic;
import com.projetPFE.crud.model.DataSourceModel;
import com.projetPFE.crud.model.SourcePropertiesModel;

@Service
public class SourcePropService {
	@Autowired
	SourcePropertyRepoElastic repo;
	
	public String updateDS(SourcePropertiesModel ss) {
		try {
			if (repo.existsById(ss.getIdSourceprop())) {
				repo.save(ss);
				return "data updated successfully.";
			} else {
				return "data does not exist.";
			}
		}catch (Exception e) {
			throw e;
		}
	}
	public String removeData(SourcePropertiesModel ss) {
		try {
			if (repo.existsById(ss.getIdSourceprop())) {
				repo.delete(ss);
				return "data deleted successfully.";
			} else {
				return "data does not exist.";
			}
		}catch (Exception e) {
			throw e;
		}
	}

}
