package com.projetPFE.crud.model;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Document(indexName = "sourceproperty_new", createIndex = true)


public class SourcePropertiesModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idSourceprop;
	@Field(type = FieldType.Text)

	private String value;
	
	@Field(type = FieldType.Text)

	private String loginModif;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")

	@Field(type = FieldType.Date, format = DateFormat.basic_date)

	private Date dateModif;
	
	//@ManyToOne
	 // @JoinColumn(name="propertiesmodel")
	@Field(type = FieldType.Nested)

	  private PropertiesModel properties;

	public SourcePropertiesModel() {
		
	}

	public SourcePropertiesModel(int idSourceprop, String value, String loginModif, Date dateModif,
			PropertiesModel properties) {
		super();
		this.idSourceprop = idSourceprop;
		this.value = value;
		this.loginModif = loginModif;
		this.dateModif = dateModif;
		this.properties = properties;
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

	public PropertiesModel getProperties() {
		return properties;
	}

	public void setProperties(PropertiesModel properties) {
		this.properties = properties;
	}

	@Override
	public String toString() {
		return "SourcePropertiesModel [idSourceprop=" + idSourceprop + ", value=" + value + ", loginModif=" + loginModif
				+ ", dateModif=" + dateModif + ", properties=" + properties + "]";
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SourcePropertiesModel other = (SourcePropertiesModel) obj;
		if (dateModif == null) {
			if (other.dateModif != null)
				return false;
		} else if (!dateModif.equals(other.dateModif))
			return false;
		if (idSourceprop != other.idSourceprop)
			return false;
		if (loginModif == null) {
			if (other.loginModif != null)
				return false;
		} else if (!loginModif.equals(other.loginModif))
			return false;
		if (properties == null) {
			if (other.properties != null)
				return false;
		} else if (!properties.equals(other.properties))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}
	
	
	

}
