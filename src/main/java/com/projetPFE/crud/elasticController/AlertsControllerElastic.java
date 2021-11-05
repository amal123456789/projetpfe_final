package com.projetPFE.crud.elasticController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projetPFE.crud.RepositoryElastic.AlertsElasticRepo;
import com.projetPFE.crud.elasticService.AlertsService;
import com.projetPFE.crud.model.AlertsModel;

@RestController
@RequestMapping("apialertskibana")

@CrossOrigin(origins = "*")
public class AlertsControllerElastic {
	@Autowired
	AlertsService  service ;
	@Autowired
	AlertsElasticRepo repo;
	
	//aaa
	///haya
	
	//http://localhost:8383/apilogs/allhitlog
	@GetMapping("/allhitalrts")
	public List<AlertsModel> getLogsModels(){
		int c = 0 ;
		 Iterator<AlertsModel> iterator= repo.findAll().iterator();
		 List<AlertsModel> students=new ArrayList<AlertsModel>();
		 while(iterator.hasNext()){
			 students.add(iterator.next());
		 }
		 return students;
	}
	//amal khezami
	//http://localhost:8383/apilogs/addlog
	@PostMapping("/addalerts")
	public String addLogsModel(@RequestBody AlertsModel user) {
		try {
			if (!repo.existsById(user.getId())) {
				repo.save(user);
				return "Data added successfully";
			}else {
				return "This Data already exists in the database.";
			}
		}catch (Exception e) {
			throw e;
		}
	}
	
	

	
	@GetMapping("/getalerts/{id}")
	public Optional<AlertsModel> getLogsModel(@PathVariable Integer id){
		return repo.findById(id);
	}
	
	
	//http://localhost:8383/apilogs/updatelog
	@RequestMapping(value = "/updatealerts", method = RequestMethod.PUT)
	public String updateLogs(@RequestBody AlertsModel prop) {
		return  service.updatelogs(prop);
	}
	
	//http://localhost:8383/apilogs/deletelog
	@RequestMapping(value = "/deletealerts", method = RequestMethod.DELETE)
	public String removeLogs(@RequestBody AlertsModel prop) {
		return service.removeDatalogs(prop);
	}
	
	

}
