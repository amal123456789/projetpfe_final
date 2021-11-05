package com.projetPFE.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projetPFE.crud.entity.Properties;
import com.projetPFE.crud.model.PropertiesModel;
import com.projetPFE.crud.service.PropertiesService;

@RestController
@CrossOrigin(origins = "*")
public class PropertiesController {
	@Autowired
	PropertiesService pService;
	
	@RequestMapping(value = "getallproperties", method = RequestMethod.GET)
	public List<PropertiesModel> getAllDatas(){
		return pService.getAllDataPropertiess();
	}
	
	@RequestMapping(value = "addproperties", method = RequestMethod.POST)
	public String addProperties(@RequestBody Properties  properties) {
		return pService.addProperties(properties);
	}
	
	@RequestMapping(value = "updateproperties", method = RequestMethod.PUT)
	public String updateProperties(@RequestBody Properties  properties) {
		return  pService.updateDProperties(properties);
	}
	
	@RequestMapping(value = "deleteproperties", method = RequestMethod.DELETE)
	public String removeProperties(@RequestBody Properties  properties) {
		return pService.removeProperties(properties);
	}

}
