package com.projetPFE.crud.RepositoryElastic;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.projetPFE.crud.model.PropertiesModel;

@Repository
public interface PropertiesRepoElastic extends ElasticsearchRepository<PropertiesModel,Integer>{

	
	public boolean existsById(int id);

	public boolean existsByPropName(String propName);
	List<PropertiesModel> findPropertiesModelByPropName(String propName);

}
