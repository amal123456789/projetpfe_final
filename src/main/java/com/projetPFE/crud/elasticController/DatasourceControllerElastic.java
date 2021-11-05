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

import com.projetPFE.crud.RepositoryElastic.DataSourceRepoElastic;
import com.projetPFE.crud.elasticService.DSservice;
import com.projetPFE.crud.entity.DataSource;
import com.projetPFE.crud.model.DataSourceModel;
@RestController
@RequestMapping("apidatasource")

@CrossOrigin(origins = "*")
public class DatasourceControllerElastic {

	
	@Autowired
	DataSourceRepoElastic repo;
	@Autowired
	DSservice service;
	@GetMapping("/allhitsource")
	public List<DataSourceModel> getDataSourceModels(){
		 Iterator<DataSourceModel> iterator= repo.findAll().iterator();
		 List<DataSourceModel> students=new ArrayList<DataSourceModel>();
		 while(iterator.hasNext()){
			 students.add(iterator.next());
		 }
		 return students;
	}
	
	
	@PostMapping("/ajouterdtsource")
	public String addDataSourceModel(@RequestBody DataSourceModel user) {
		try {
			if (!repo.existsById(user.getIdSourceSequence())) {
				repo.save(user);
				return "Employee added successfully";
			}else {
				return "This employee already exists in the database.";
			}
		}catch (Exception e) {
			throw e;
		}
	}
	
	

	
	@GetMapping("/getdtsource/{id}")
	public Optional<DataSourceModel> getDataSourceModel(@PathVariable Integer id){
		return repo.findById(id);
	}
	
	@RequestMapping(value = "updatedatasourceelastic", method = RequestMethod.PUT)
	public String updateDataSource(@RequestBody DataSourceModel dataSource) {
		return  service.updateDS(dataSource);
	}
	/*@PutMapping("/updatedsource/{id}")
	   public DataSourceModel updateDataSourceModel(@PathVariable Integer id,@RequestBody DataSourceModel student){
		   Optional<DataSourceModel> std= repo.findById(id);
		   if(std.isPresent()){
			   DataSourceModel s=std.get();
			   s.setSystemCode(student.getSystemCode());
		   return repo.save(s);
		   }
		   else
			   return null;
	   }
	
	@DeleteMapping("/deletedsource")
	   public String deleteDataSourceModel(@RequestBody DataSourceModel dataSource){
		  return "Document Deleted";
	   }*/

	
	@RequestMapping(value = "deleteds", method = RequestMethod.DELETE)
	public String removeUser(@RequestBody DataSourceModel dataSource) {
		return service.removeData(dataSource);
	}
	
	
	
	
}
