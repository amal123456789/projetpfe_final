package com.projetPFE.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projetPFE.crud.entity.DataDestination;
import com.projetPFE.crud.entity.Logs;
import com.projetPFE.crud.model.DataDestinationModel;
import com.projetPFE.crud.model.LogsModel;
import com.projetPFE.crud.service.LogsService;

@RestController
@CrossOrigin(origins = "*")
public class LogsController {
	@Autowired
	LogsService service;
	
	@RequestMapping(value = "getalllogs", method = RequestMethod.GET)
	public List<Logs> getAllDatadests(){
		return service.getAllDatalogs();
	}
	

	@RequestMapping(value = "getByMethode", method = RequestMethod.POST)
	public List<Logs> addDataDestination(@RequestBody String methode) {
		return service.getByMethode(methode);
	}
	
	@RequestMapping(value = "addlogs", method = RequestMethod.POST)
	public String addDataDestination(@RequestBody Logs datadestination) {
		return service.addData(datadestination);
	}
	
	@RequestMapping(value = "updatelogs", method = RequestMethod.PUT)
	public String updateDataDestination(@RequestBody Logs dataDestination) {
		return  service.updateData(dataDestination);
	}
	
	@RequestMapping(value = "deletelogs", method = RequestMethod.DELETE)
	public String removeDataDestination(@RequestBody Logs dataDestination) {
		return service.removeData(dataDestination);
	}
	

}
