package com.projetPFE.crud.RepositoryElastic;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.projetPFE.crud.model.DataSourceModel;
@Repository
public interface DataSourceRepoElastic extends ElasticsearchRepository<DataSourceModel ,Integer>{
	public boolean existsById(int id);

	public boolean existsBySystemName(String systemName);
	List<DataSourceModel> findDataSourceModelBySystemName(String systemName);
}
