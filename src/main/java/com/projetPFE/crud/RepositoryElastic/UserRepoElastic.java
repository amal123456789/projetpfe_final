package com.projetPFE.crud.RepositoryElastic;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.projetPFE.crud.model.UserModel;
@Repository
public interface UserRepoElastic extends ElasticsearchRepository<UserModel, Integer> {

	//Page<UserModel> findUserModelByfirstName(String firstName, Pageable pageable);

    /*@Query("{\"bool\": {\"must\": [{\"match\": {\"users.firstName\": \"?0\"}}]}}")
    Page<UserModel> findByUserModelNameUsingCustomQuery(String name, Pageable pageable);
*/
	public boolean existsById(int id);

	public boolean existsByLastName(String lastName);
	List<UserModel> findUserModelByFirstName(String firstName);

	
	
}

