package com.projetPFE.crud.RepositoryElastic;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.projetPFE.crud.model.DataDestinationModel;
@Repository
public interface DataDestinationRepoElastic extends ElasticsearchRepository<DataDestinationModel, Integer>{

	public boolean existsById(int id);
	public boolean existsByIpAdressDestination(String ipAdressDestination);
	List<DataDestinationModel> findDataDestinationModelByipAdressDestination(String DataDestinationModel);


}
