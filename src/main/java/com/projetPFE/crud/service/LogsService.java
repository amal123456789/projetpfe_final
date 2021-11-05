package com.projetPFE.crud.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetPFE.crud.entity.DataDestination;
import com.projetPFE.crud.entity.Logs;
import com.projetPFE.crud.model.LogsModel;
import com.projetPFE.crud.repository.LogsRepository;

@Service
public class LogsService {
	@Autowired
	LogsRepository repo;
	
	
	
public List<Logs> getAllDatalogs(){
		
		/*try {
			List<Logs> datasources = repo.findAll();
			List<LogsModel> customDataSources = new ArrayList<>();
			datasources.stream().forEach(e -> {
				LogsModel datasource = new LogsModel();
				BeanUtils.copyProperties(e, datasource);
				customDataSources.add(datasource);
			});
			return customDataSources;
		}catch(Exception e) {
			throw e;
		}*/
	
	Iterator<Logs> iterator= repo.findAll().iterator();
	 List<Logs> students=new ArrayList<Logs>();
	 while(iterator.hasNext()){
		 students.add(iterator.next());
	 }
	 return students;
	
	
	}

public List<Logs> getByMethode(String methode){
	

Iterator<Logs> iterator= repo.findByMETHODE(methode).iterator();
 List<Logs> students=new ArrayList<Logs>();
 while(iterator.hasNext()){
	 students.add(iterator.next());
 }
 return students;


}

	public String addData(Logs dataSource) {
		try {
			if (!repo.existsById(dataSource.getId())) {
				repo.save(dataSource);
				return "data added successfully";
			}else {
				return "This data already exists in the database.";
			}
		}catch (Exception e) {
			throw e;
		}
	}
	
	public String removeData(Logs dataSource) {
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
	
	public String updateData(Logs dataSource) {
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


}
