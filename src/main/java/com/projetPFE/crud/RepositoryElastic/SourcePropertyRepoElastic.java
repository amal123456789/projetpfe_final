package com.projetPFE.crud.RepositoryElastic;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.projetPFE.crud.model.SourcePropertiesModel;
@Repository
public interface SourcePropertyRepoElastic extends ElasticsearchRepository<SourcePropertiesModel , Integer>{

	public boolean existsById(int id);

	public boolean existsByValue(String value);
	List<SourcePropertiesModel> findSourcePropertiesModelByValue(String value);

	
}
