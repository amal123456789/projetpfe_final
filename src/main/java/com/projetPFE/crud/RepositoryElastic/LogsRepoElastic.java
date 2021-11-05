package com.projetPFE.crud.RepositoryElastic;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.projetPFE.crud.model.LogsModel;
@Repository
public interface LogsRepoElastic extends ElasticsearchRepository<LogsModel, Integer> {
	public boolean existsByType(String type);
	public boolean existsById(int id);
}
