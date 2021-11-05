package com.projetPFE.crud.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "properties_new", createIndex = true)

public class PropertiesModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
private int idProperty;
	@Field(type = FieldType.Text)

	private String codeProp;
	@Field(type = FieldType.Text)

	private String propName;
	@Field(type = FieldType.Text)

	private String classe;
	
	
	//@ManyToOne
	 // @JoinColumn(name="sourcepropertiesmodel")
	@Field(type = FieldType.Nested)

	  private SourcePropertiesModel sourceproperties;


	public PropertiesModel() {
		
	}


	public PropertiesModel(int idProperty, String codeProp, String propName, String classe,
			SourcePropertiesModel sourceproperties) {
		super();
		this.idProperty = idProperty;
		this.codeProp = codeProp;
		this.propName = propName;
		this.classe = classe;
		this.sourceproperties = sourceproperties;
	}


	public int getIdProperty() {
		return idProperty;
	}


	public void setIdProperty(int idProperty) {
		this.idProperty = idProperty;
	}


	public String getCodeProp() {
		return codeProp;
	}


	public void setCodeProp(String codeProp) {
		this.codeProp = codeProp;
	}


	public String getPropName() {
		return propName;
	}


	public void setPropName(String propName) {
		this.propName = propName;
	}


	public String getClasse() {
		return classe;
	}


	public void setClasse(String classe) {
		this.classe = classe;
	}


	public SourcePropertiesModel getSourceproperties() {
		return sourceproperties;
	}


	public void setSourceproperties(SourcePropertiesModel sourceproperties) {
		this.sourceproperties = sourceproperties;
	}


	@Override
	public String toString() {
		return "PropertiesModel [idProperty=" + idProperty + ", codeProp=" + codeProp + ", propName=" + propName
				+ ", classe=" + classe + ", sourceproperties=" + sourceproperties + "]";
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PropertiesModel other = (PropertiesModel) obj;
		if (classe == null) {
			if (other.classe != null)
				return false;
		} else if (!classe.equals(other.classe))
			return false;
		if (codeProp == null) {
			if (other.codeProp != null)
				return false;
		} else if (!codeProp.equals(other.codeProp))
			return false;
		if (idProperty != other.idProperty)
			return false;
		if (propName == null) {
			if (other.propName != null)
				return false;
		} else if (!propName.equals(other.propName))
			return false;
		if (sourceproperties == null) {
			if (other.sourceproperties != null)
				return false;
		} else if (!sourceproperties.equals(other.sourceproperties))
			return false;
		return true;
	}

	
	
	
}
