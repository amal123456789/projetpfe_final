package com.projetPFE.crud.elasticController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

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

import com.projetPFE.crud.RepositoryElastic.PropertiesRepoElastic;
import com.projetPFE.crud.elasticService.PropElasticService;
import com.projetPFE.crud.model.DataDestinationModel;
import com.projetPFE.crud.model.DataSourceModel;
import com.projetPFE.crud.model.PropertiesModel;
@RestController
@RequestMapping("apiproperties")

@CrossOrigin(origins = "*")
public class PropertiesElasticController {

	@Autowired
	PropertiesRepoElastic repo;
	
	@Autowired
	PropElasticService service ;
	@GetMapping("/allhitprop")
	public List<PropertiesModel> getPropertiesModels(){
		 Iterator<PropertiesModel> iterator= repo.findAll().iterator();
		 List<PropertiesModel> students=new ArrayList<PropertiesModel>();
		 while(iterator.hasNext()){
			 students.add(iterator.next());
		 }
		 return students;
	}
	
	
	@PostMapping("/addprop")
	public String addPropertiesModel(@RequestBody PropertiesModel user) {
		try {
			if (!repo.existsById(user.getIdProperty())) {
				repo.save(user);
				return "Employee added successfully";
			}else {
				return "This employee already exists in the database.";
			}
		}catch (Exception e) {
			throw e;
		}
	}
	
	

	
	@GetMapping("/getprop/{id}")
	public Optional<PropertiesModel> getPropertiesModel(@PathVariable Integer id){
		return repo.findById(id);
	}
	
	
	
	@RequestMapping(value = "updateprop", method = RequestMethod.PUT)
	public String updateDataSource(@RequestBody PropertiesModel prop) {
		return  service.updateDS(prop);
	}
	
	
	@RequestMapping(value = "deleteprop", method = RequestMethod.DELETE)
	public String removeUser(@RequestBody PropertiesModel prop) {
		return service.removeData(prop);
	}
	/*@PutMapping("/updateprop/{id}")
	   public PropertiesModel updatePropertiesModel(@PathVariable Integer id,@RequestBody PropertiesModel student){
		   Optional<PropertiesModel> std= repo.findById(id);
		   if(std.isPresent()){
			   PropertiesModel s=std.get();
			   s.setCodeProp(student.getCodeProp());
		   return repo.save(s);
		   }
		   else
			   return null;
	   }
	
	@DeleteMapping("/deleteprop/{id}")
	   public String deletePropertiesModel(@PathVariable Integer id){
		  repo.deleteById(id);
		  return "Document Deleted";
	   }
*/
	

	
	
}
