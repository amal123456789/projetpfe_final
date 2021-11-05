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

import com.projetPFE.crud.RepositoryElastic.SourcePropertyRepoElastic;
import com.projetPFE.crud.elasticService.SourcePropService;
import com.projetPFE.crud.model.DataSourceModel;
import com.projetPFE.crud.model.SourcePropertiesModel;

@RestController
@RequestMapping("apisourceproperty")

@CrossOrigin(origins = "*")

public class SourcePropertyElasticController {
	
	
	@Autowired
		SourcePropertyRepoElastic repo;
	@Autowired
	SourcePropService service ;
		
		@GetMapping("/allhitsourceprop")
		public List<SourcePropertiesModel> getSourcePropertiesModels(){
			 Iterator<SourcePropertiesModel> iterator= repo.findAll().iterator();
			 List<SourcePropertiesModel> students=new ArrayList<SourcePropertiesModel>();
			 while(iterator.hasNext()){
				 students.add(iterator.next());
			 }
			 return students;
		}
		
		
		@PostMapping("/ajoutersourceprop")
		public String addSourcePropertiesModel(@RequestBody SourcePropertiesModel user) {
			try {
				if (!repo.existsById(user.getIdSourceprop())) {
					repo.save(user);
					return "Employee added successfully";
				}else {
					return "This employee already exists in the database.";
				}
			}catch (Exception e) {
				throw e;
			}
		}
		
		

		
		@GetMapping("/getsourceprop/{id}")
		public Optional<SourcePropertiesModel> getSourcePropertiesModel(@PathVariable Integer id){
			return repo.findById(id);
		}
		
		
		/*@PutMapping("/updatesourceprop/{id}")
		   public SourcePropertiesModel updateSourcePropertiesModel(@PathVariable Integer id,@RequestBody SourcePropertiesModel student){
			   Optional<SourcePropertiesModel> std= repo.findById(id);
			   if(std.isPresent()){
				   SourcePropertiesModel s=std.get();
				   s.setValue(student.getValue());
			   return repo.save(s);
			   }
			   else
				   return null;
		   }
		
		@DeleteMapping("/deletesourcespop/{id}")
		   public String deleteSourcePropertiesModel(@PathVariable Integer id){
			  repo.deleteById(id);
			  return "Document Deleted";
		   }*/
		@RequestMapping(value = "updatesourceprop", method = RequestMethod.PUT)
		public String updateDataSource(@RequestBody SourcePropertiesModel dataSource) {
			return  service.updateDS(dataSource);
		}
		
		@RequestMapping(value = "deletesourcespop", method = RequestMethod.DELETE)
		public String removeUser(@RequestBody SourcePropertiesModel dataSource) {
			return service.removeData(dataSource);
		}
		

	}


