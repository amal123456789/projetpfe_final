package com.projetPFE.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projetPFE.crud.entity.DataSource;
import com.projetPFE.crud.model.DataSourceModel;
import com.projetPFE.crud.service.DataSourceService;

@RestController
@CrossOrigin(origins = "*")
public class DataSourceContoller {
	
	@Autowired
	DataSourceService daService;
	
	
	@RequestMapping(value = "getalldatasource", method = RequestMethod.GET)
	public List<DataSourceModel> getAllDatas(){
		return daService.getAllDataSources();
	}
	
	@RequestMapping(value = "addatasource", method = RequestMethod.POST)
	public String addDataSource(@RequestBody DataSource dataSource) {
		return daService.addData(dataSource);
	}
	
	@RequestMapping(value = "updatedatasource", method = RequestMethod.PUT)
	public String updateDataSource(@RequestBody DataSource dataSource) {
		return  daService.updateData(dataSource);
	}
	
	@RequestMapping(value = "deletedatasource", method = RequestMethod.DELETE)
	public String removeUser(@RequestBody DataSource dataSource) {
		return daService.removeData(dataSource);
	}
	
	@RequestMapping(value = "deletedatasource/{id}", method = RequestMethod.DELETE)
	public String removeDatasource(@PathVariable int id) {
		return daService.removeData(id);
	}
}
