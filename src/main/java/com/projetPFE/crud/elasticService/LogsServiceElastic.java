package com.projetPFE.crud.elasticService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetPFE.crud.RepositoryElastic.LogsRepoElastic;
import com.projetPFE.crud.model.DataSourceModel;
import com.projetPFE.crud.model.LogsModel;
@Service
public class LogsServiceElastic {
	
	@Autowired
	LogsRepoElastic repo;
	
	
	public String updateDS(LogsModel dataSource) {
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
	public String removeData(LogsModel dataSource) {
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
