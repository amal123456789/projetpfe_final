package com.projetPFE.crud.elasticController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.core.DocumentOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projetPFE.crud.RepositoryElastic.UserRepoElastic;
import com.projetPFE.crud.elasticService.UserServiceElastic;
import com.projetPFE.crud.entity.User;
import com.projetPFE.crud.model.DataSourceModel;
import com.projetPFE.crud.model.UserModel;


@RestController
@RequestMapping("apiuser")

@CrossOrigin(origins = "*")
public class UserControllerElastic {
	@Autowired
	UserServiceElastic serviceElastic ;
	
	
	
	
	///////////***********this  the right code
	
	@Autowired
	UserRepoElastic userRepoElastic ;
	

	@GetMapping("/allhit")
	public List<UserModel> getUserModels(){
		 Iterator<UserModel> iterator= userRepoElastic.findAll().iterator();
		 List<UserModel> students=new ArrayList<UserModel>();
		 while(iterator.hasNext()){
			 students.add(iterator.next());
		 }
		 return students;
	}
	
	
	@PostMapping("/ajouter")
	public String addUserModel(@RequestBody UserModel user) {
		try {
			if (!userRepoElastic.existsById(user.getId())) {
				userRepoElastic.save(user);
				return "Employee added successfully";
			}else {
				return "This employee already exists in the database.";
			}
		}catch (Exception e) {
			throw e;
		}
	}
	

	@RequestMapping(value = "updateuserelastic", method = RequestMethod.PUT)
	public String updateDataSource(@RequestBody UserModel user) {
		return  serviceElastic.updateUser(user);
	}

	@RequestMapping(value = "deleteuser", method = RequestMethod.DELETE)
	public String removeUser(@RequestBody UserModel user) {
		return serviceElastic.removeUser(user);
	}
	
	@GetMapping("/getus/{id}")
	public Optional<UserModel> getStudent(@PathVariable Integer id){
		return userRepoElastic.findById(id);
	}
	
	
	
	
	/*@PutMapping("/updated/{id}")
	   public UserModel updateStudent(@PathVariable Integer id,@RequestBody UserModel student){
		   Optional<UserModel> std= userRepoElastic.findById(id);
		   if(std.isPresent()){
			   UserModel s=std.get();
			   s.setFirstName(student.getFirstName());
		   return userRepoElastic.save(s);
		   }
		   else
			   return null;
	   }
	
	@DeleteMapping("/deleted/{id}")
	   public String deleteStudent(@PathVariable Integer id){
		  userRepoElastic.deleteById(id);
		  return "Document Deleted";
	   }
*/
	

	
	
	/***** Elastic Search APIs *****/

	  /* @GetMapping(value = "/es/index")
	   public String indexEmployee() {
		   serviceElastic.indexData();
	       return "Data indexed Successfully";
	   }

	   @GetMapping(value = "/all")
	   public Page<UserModel> searchAll() {
	       List<UserModel> usersList = new ArrayList<>();
	       Page<UserModel> emps = (Page<UserModel>) userRepoElastic.findAll();
	       emps.forEach(usersList::add);
	       return (Page<UserModel>) emps;
	   }

	   @GetMapping(value = "/es/deleteindexes")
	   public String deleteIndexes() {
		   userRepoElastic.deleteAll();
	       return "Deleted all indexes";
	   }
	  
	
	*/
	
	
	
	
	
	///////////////////******
	
	
	
	
	
	/*@GetMapping(path = "/search",produces = "application/json")

	public Set<UserModel> searchUserByFirstname(
			@RequestParam(value = "firstName", defaultValue = "") String firstName) throws IOException {
				  List<UserModel> users= new ArrayList<>();
				  serviceElastic.getUserByFistname(firstName).forEach(userModel -> {
				  users.add( new UserModel(userModel.getFirstName(),userModel.getId(), userModel.getLastName()));
					});
				  return users.stream()
						  .collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(UserModel::getId))));
				  
				 
				}*/
	///////////////////////***** test
	
	
	
	@RequestMapping("/aa")
    public String SpringBootESExample() {
        return "Welcome to Spring Boot Elastic Search Example";
    }

	
}
