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

import com.projetPFE.crud.RepositoryElastic.LogsRepoElastic;
import com.projetPFE.crud.elasticService.LogsServiceElastic;
import com.projetPFE.crud.model.LogsModel;


@RestController
@RequestMapping("apilogs")

@CrossOrigin(origins = "*")
public class LogsElasticController {
	@Autowired
	LogsServiceElastic  service ;
	@Autowired
	LogsRepoElastic repo;
	
	
	
	
	@GetMapping("/allhitlog")
	public List<LogsModel> getLogsModels(){
		 Iterator<LogsModel> iterator= repo.findAll().iterator();
		 List<LogsModel> students=new ArrayList<LogsModel>();
		 while(iterator.hasNext()){
			 
			 students.add(iterator.next());
		 }
		 return students;
	}
	
	
	@PostMapping("/addlog")
	public String addLogsModel(@RequestBody LogsModel user) {
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
	
	

	
	@GetMapping("/getlog/{id}")
	public Optional<LogsModel> getLogsModel(@PathVariable Integer id){
		return repo.findById(id);
	}
	
	
	
	@RequestMapping(value = "/updatelog", method = RequestMethod.PUT)
	public String updateLogs(@RequestBody LogsModel prop) {
		return  service.updateDS(prop);
	}
	
	
	@RequestMapping(value = "/deletelog", method = RequestMethod.DELETE)
	public String removeLogs(@RequestBody LogsModel prop) {
		return service.removeData(prop);
	}
	
	

}
