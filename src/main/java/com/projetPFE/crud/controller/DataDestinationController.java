package com.projetPFE.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projetPFE.crud.entity.DataDestination;
import com.projetPFE.crud.model.DataDestinationModel;
import com.projetPFE.crud.service.DataDestinationService;

@RestController
@CrossOrigin(origins = "*")
public class DataDestinationController {

	@Autowired
	DataDestinationService daServicedest;
	
	
	@RequestMapping(value = "getalldatadestnew", method = RequestMethod.GET)
	public List<DataDestination> getAllDatadests(){
		return daServicedest.getDatadests();
	}
	
	@RequestMapping(value = "getalldatadest", method = RequestMethod.GET)
	public List<DataDestinationModel> getAllDatas(){
		return daServicedest.getAllDataSources();
	}
	
	@RequestMapping(value = "addatadest", method = RequestMethod.POST)
	public String addDataDestination(@RequestBody DataDestination datadestination) {
		return daServicedest.addData(datadestination);
	}
	
	@RequestMapping(value = "updatedatadest", method = RequestMethod.PUT)
	public String updateDataDestination(@RequestBody DataDestination dataDestination) {
		return  daServicedest.updateData(dataDestination);
	}
	
	@RequestMapping(value = "deletedatadest", method = RequestMethod.DELETE)
	public String removeDataDestination(@RequestBody DataDestination dataDestination) {
		return daServicedest.removeData(dataDestination);
	}
}
