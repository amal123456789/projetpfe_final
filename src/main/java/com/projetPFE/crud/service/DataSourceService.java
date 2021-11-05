package com.projetPFE.crud.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetPFE.crud.entity.DataSource;
import com.projetPFE.crud.entity.Properties;
import com.projetPFE.crud.entity.SourceProperties;
import com.projetPFE.crud.model.DataSourceModel;
import com.projetPFE.crud.repository.DataSourceRepository;
import com.projetPFE.crud.repository.PropertiesRepository;
import com.projetPFE.crud.repository.SourcePropertiesRepository;

@Service
public class DataSourceService {
	@Autowired
	DataSourceRepository dataSourceRepository;

	@Autowired
	SourcePropertiesRepository sourcePropertiesRepository;

	@Autowired
	PropertiesRepository propertiesRepository;

	public List<DataSourceModel> getAllDataSources() {

		try {
			List<DataSource> datasources = dataSourceRepository.findAll();
			List<DataSourceModel> customDataSources = new ArrayList<>();
			datasources.stream().forEach(e -> {
				DataSourceModel datasource = new DataSourceModel();
				BeanUtils.copyProperties(e, datasource);
				datasource.setIdSourceprop(e.getSourceprop().getIdSourceprop());
				customDataSources.add(datasource);
			});
			return customDataSources;
		} catch (Exception e) {
			throw e;
		}
	}

	public String addData(DataSource dataSource) {
		try {
			if (!dataSourceRepository.existsBySchemaUrl(dataSource.getSchemaUrl())) {
				dataSourceRepository.save(dataSource);
				return "data added successfully";
			} else {
				return "This data already exists in the database.";
			}
		} catch (Exception e) {
			throw e;
		}
	}

	public String removeData(DataSource dataSource) {
		try {
			if (dataSourceRepository.existsBySchemaUrl(dataSource.getSchemaUrl())) {
				dataSourceRepository.delete(dataSource);
				return "data deleted successfully.";
			} else {
				return "data does not exist.";
			}
		} catch (Exception e) {
			throw e;
		}
	}

	public String updateData(DataSource dataSource) {
		try {
			if (dataSourceRepository.existsById(dataSource.getIdSourceSequence())) {
				if (dataSource.getIdSourceprop() != 0) {
					Optional<SourceProperties> sourceProp = sourcePropertiesRepository
							.findById(dataSource.getIdSourceprop());
					if (sourceProp.isPresent()) {
						dataSource.setSourceprop(sourceProp.get());
					}
				}
				dataSourceRepository.save(dataSource);
				return "data updated successfully.";
			} else {
				return "data does not exist.";
			}
		} catch (Exception e) {
			throw e;
		}
	}

	public String removeData(int id) {
		try {
			Optional<DataSource> datasourceOP = dataSourceRepository.findById(id);
			if (datasourceOP.isPresent()) {
				DataSource dataSource = datasourceOP.get();
				SourceProperties sourceprop = dataSource.getSourceprop();
				if (sourceprop != null) {
					Properties properties = sourceprop.getProperties();
					if (properties != null) {
						propertiesRepository.delete(properties);
					}
					sourcePropertiesRepository.delete(sourceprop);
				}
				dataSourceRepository.deleteById(id);
				return "data deleted successfully.";
			} else {
				return "data does not exist.";
			}
		} catch (Exception e) {
			throw e;
		}
	}

}
