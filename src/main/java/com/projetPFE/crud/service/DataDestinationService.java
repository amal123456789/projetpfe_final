package com.projetPFE.crud.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetPFE.crud.entity.DataDestination;
import com.projetPFE.crud.entity.DataSource;
import com.projetPFE.crud.model.DataDestinationModel;
import com.projetPFE.crud.model.DataSourceModel;
import com.projetPFE.crud.repository.DataDestinationRepository;


@Service
public class DataDestinationService {
	
	@Autowired
	DataDestinationRepository datadestrepo;
	
	public List<DataDestination> getDatadests(){
		 Iterator<DataDestination> iterator= datadestrepo.findAll().iterator();
		 List<DataDestination> students=new ArrayList<DataDestination>();
		 while(iterator.hasNext()){
			 students.add(iterator.next());
		 }
		 return students;
	}
	
	
	
	
	
	
public List<DataDestinationModel> getAllDataSources(){
		
		try {
			List<DataDestination> datasources = datadestrepo.findAll();
			List<DataDestinationModel> customDataSources = new ArrayList<>();
			datasources.stream().forEach(e -> {
				DataDestinationModel datasource = new DataDestinationModel();
				BeanUtils.copyProperties(e, datasource);
				customDataSources.add(datasource);
			});
			return customDataSources;
		}catch(Exception e) {
			throw e;
		}
	}
	
	public String addData(DataDestination datadetination) {
		try {
			if (!datadestrepo.existsByipAdressDestination(datadetination.getIpAdressDestination())) {
				datadestrepo.save(datadetination);
				return "data added successfully";
			}else {
				return "This data already exists in the database.";
			}
		}catch (Exception e) {
			throw e;
		}
	}
	
	public String removeData(DataDestination datadetination) {
		try {
			if (datadestrepo.existsByipAdressDestination(datadetination.getIpAdressDestination())) {
				datadestrepo.delete(datadetination);
				return "data deleted successfully.";
			} else {
				return "data does not exist.";
			}
		}catch (Exception e) {
			throw e;
		}
	}
	
	public String updateData(DataDestination datadetination) {
		try {
			if (datadestrepo.existsById(datadetination.getIdDestination())) {
				datadestrepo.save(datadetination);
				return "data updated successfully.";
			} else {
				return "data does not exist.";
			}
		}catch (Exception e) {
			throw e;
		}
	}

}
