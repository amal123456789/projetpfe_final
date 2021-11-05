package com.projetPFE.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projetPFE.crud.entity.SourceProperties;
import com.projetPFE.crud.model.SourcePropertiesModel;
import com.projetPFE.crud.service.SourcePropertiesService;

@RestController
@CrossOrigin(origins = "*")
public class SourcePropertiesController {
	
	@Autowired
	SourcePropertiesService spService;

	@RequestMapping(value = "getsourceprop/{id}", method = RequestMethod.GET)
	public SourcePropertiesModel getDataSources(@PathVariable int id){
		return spService.getSourceProperties(id);
	}
	
	@RequestMapping(value = "getallsourceprop", method = RequestMethod.GET)
	public List<SourcePropertiesModel> getAllDataSources(){
		return spService.getAllSourcePropertiess();
	}
	
	@RequestMapping(value = "addsourceproperties", method = RequestMethod.POST)
	public String addProperties(@RequestBody SourceProperties  properties) {
		return spService.addSourceProperties(properties);
	}
	
	@RequestMapping(value = "updatesourceproperties", method = RequestMethod.PUT)
	public String updateSourceProperties(@RequestBody SourceProperties  properties) {
		return  spService.updateSourceProperties(properties);
	}
	
	@RequestMapping(value = "deletesourceproperties", method = RequestMethod.DELETE)
	public String removeProperties(@RequestBody SourceProperties  properties) {
		return spService.removeSourceProperties(properties);
	}
}
