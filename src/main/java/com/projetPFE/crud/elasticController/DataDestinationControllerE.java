package com.projetPFE.crud.elasticController;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projetPFE.crud.RepositoryElastic.DataDestinationRepoElastic;
import com.projetPFE.crud.elasticService.DataDestService;
import com.projetPFE.crud.model.DataDestinationModel;
import com.projetPFE.crud.model.UserModel;




@RestController
@RequestMapping("apidatadest")

@CrossOrigin(origins = "*")
public class DataDestinationControllerE {

	//private static final Logger logger=LoggerFactory.getLogger(DataDestinationControllerE.class);
	@Autowired
	DataDestinationRepoElastic repo;
	
	@Autowired
	DataDestService service;
	@GetMapping("/allhitdatadestination")
	public List<DataDestinationModel> getDataDestinationModels(){
		 Iterator<DataDestinationModel> iterator= repo.findAll().iterator();
		 List<DataDestinationModel> students=new ArrayList<DataDestinationModel>();
		 while(iterator.hasNext()){
			 students.add(iterator.next());
		 }
		 return students;
	}
	
	
	@PostMapping("/ajouterdtdest")
	public String addDataDestinationModel(@RequestBody DataDestinationModel user) {
		try {
			if (!repo.existsById(user.getIdDestination())) {
				repo.save(user);
				return "Employee added successfully";
			}else {
				return "This employee already exists in the database.";
			}
		}catch (Exception e) {
			throw e;
		}
	}
	
	

	
	@GetMapping("/getdtdest/{id}")
	public Optional<DataDestinationModel> getDataDestinationModel(@PathVariable Integer id){
		return repo.findById(id);
	}
	
	
	/*@PutMapping("/updateddtdest/{id}")
	   public DataDestinationModel updateDataDestinationModel(@PathVariable Integer id,@RequestBody DataDestinationModel student){
		   Optional<DataDestinationModel> std= repo.findById(id);
		   if(std.isPresent()){
			   DataDestinationModel s=std.get();
			   s.setIpAdressDestination(student.getIpAdressDestination());
		   return repo.save(s);
		   }
		   else
			   return null;
	   }
	
	@DeleteMapping("/deleteddatadest/{id}")
	   public String deleteDataDestinationModel(@PathVariable Integer id){
		  repo.deleteById(id);
		  return "Document Deleted";
	   }*/

	
	@RequestMapping(value = "updateddtdest", method = RequestMethod.PUT)
	public String updateDataSource(@RequestBody DataDestinationModel data) {
		return  service.updateDS(data);
	}

	@RequestMapping(value = "deleteddatadest", method = RequestMethod.DELETE)
	public String removeUser(@RequestBody DataDestinationModel data) {
		return service.removeData(data);
	}
	
	

}
