package com.projetPFE.crud.elasticService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetPFE.crud.RepositoryElastic.DataSourceRepoElastic;
import com.projetPFE.crud.entity.DataSource;
import com.projetPFE.crud.model.DataSourceModel;

@Service
public class DSservice {
	@Autowired
	
	DataSourceRepoElastic repo;
	
	public String updateDS(DataSourceModel dataSource) {
		try {
			if (repo.existsById(dataSource.getIdSourceSequence())) {
				repo.save(dataSource);
				return "data updated successfully.";
			} else {
				return "data does not exist.";
			}
		}catch (Exception e) {
			throw e;
		}
	}
	public String removeData(DataSourceModel dataSource) {
		try {
			if (repo.existsById(dataSource.getIdSourceSequence())) {
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
