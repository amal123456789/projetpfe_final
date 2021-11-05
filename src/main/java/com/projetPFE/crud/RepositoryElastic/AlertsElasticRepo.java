package com.projetPFE.crud.RepositoryElastic;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.projetPFE.crud.model.AlertsModel;
@Repository
public interface AlertsElasticRepo extends ElasticsearchRepository<AlertsModel, Integer> {
	public boolean existsByName(String TYPE);
	public boolean existsById(int id);
}
