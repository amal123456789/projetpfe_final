package com.projetPFE.crud.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetPFE.crud.entity.Properties;
import com.projetPFE.crud.model.PropertiesModel;
import com.projetPFE.crud.repository.PropertiesRepository;

@Service
public class PropertiesService {
	@Autowired
	 PropertiesRepository propertiesRepo;
	
public List<PropertiesModel> getAllDataPropertiess(){
		
		try {
			List<Properties> propertiess = propertiesRepo.findAll();
			List<PropertiesModel> customProperties = new ArrayList<>();
			propertiess.stream().forEach(e -> {
				PropertiesModel properties = new PropertiesModel();
				BeanUtils.copyProperties(e, properties);
				customProperties.add(properties);
			});
			return customProperties;
		}catch(Exception e) {
			throw e;
		}
	}
	
	public String addProperties(Properties properties) {
		try {
			if (!propertiesRepo.existsBycodeProp(properties.getCodeProp())) {
				propertiesRepo.save(properties);
				return "Properties added successfully";
			}else {
				return "This Properties already exists in the database.";
			}
		}catch (Exception e) {
			throw e;
		}
	}
	
	public String removeProperties(Properties properties) {
		try {
			if (propertiesRepo.existsBycodeProp(properties.getCodeProp())) {
				propertiesRepo.delete(properties);
				return "Properties deleted successfully.";
			} else {
				return "Properties does not exist.";
			}
		}catch (Exception e) {
			throw e;
		}
	}
	
	public String updateDProperties(Properties properties) {
		try {
			if (propertiesRepo.existsById(properties.getIdProperty())) {
				propertiesRepo.save(properties);
				return "Properties updated successfully.";
			} else {
				return "Properties does not exist.";
			}
		}catch (Exception e) {
			throw e;
		}
	}

}
