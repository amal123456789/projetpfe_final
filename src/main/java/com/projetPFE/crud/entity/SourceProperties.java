package com.projetPFE.crud.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity

public class SourceProperties {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idSourceprop;
	private String value;
	private String loginModif;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")

	private Date dateModif;
	
	@ManyToOne
	  @JoinColumn(name="properties")
	  private Properties properties;
	@OneToMany
	@JoinColumn(name="sourceproperties")
    private Set<DataSource> datasources;
	
	
	
	public SourceProperties() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SourceProperties(int idSourceprop, String value, String loginModif, Date dateModif, Properties properties) {
		super();
		this.idSourceprop = idSourceprop;
		this.value = value;
		this.loginModif = loginModif;
		this.dateModif = dateModif;
		this.properties = properties;
	}

	public Set<DataSource> getDatasources() {
		return datasources;
	}

	public void setDatasources(Set<DataSource> datasources) {
		this.datasources = datasources;
	}

	public int getIdSourceprop() {
		return idSourceprop;
	}

	public void setIdSourceprop(int idSourceprop) {
		this.idSourceprop = idSourceprop;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getLoginModif() {
		return loginModif;
	}

	public void setLoginModif(String loginModif) {
		this.loginModif = loginModif;
	}

	public Date getDateModif() {
		return dateModif;
	}

	public void setDateModif(Date dateModif) {
		this.dateModif = dateModif;
	}

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}
	
	
	
	
}
