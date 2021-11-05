package com.projetPFE.crud.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

//@Document(indexName = "user")
@Document(indexName = "datasource_new", createIndex = true)

public class DataSourceModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idSourceSequence;
	@Field(type = FieldType.Text)

	private String schemaUrl;
	@Field(type = FieldType.Text)

	private String systemName;
	@Field(type = FieldType.Text)

	private String systemCode;
	@Field(type = FieldType.Text)

	private String descritpionSource;
	
	private int idSourceprop;
	
	//@ManyToOne
	  //@JoinColumn(name="usermodel")
	@Field(type = FieldType.Nested)
	  private UserModel utilisateur;

	
	//@ManyToOne
	  //@JoinColumn(name="datadestinationmodel")
	@Field(type = FieldType.Nested)
	  private DataDestinationModel datadestination;


	public DataSourceModel() {
		
	}


	public DataSourceModel(int idSourceSequence, String schemaUrl, String systemName, String systemCode,
			String descritpionSource, UserModel utilisateur, DataDestinationModel datadestination) {
		super();
		this.idSourceSequence = idSourceSequence;
		this.schemaUrl = schemaUrl;
		this.systemName = systemName;
		this.systemCode = systemCode;
		this.descritpionSource = descritpionSource;
		this.utilisateur = utilisateur;
		this.datadestination = datadestination;
	}


	public int getIdSourceSequence() {
		return idSourceSequence;
	}


	public void setIdSourceSequence(int idSourceSequence) {
		this.idSourceSequence = idSourceSequence;
	}


	public String getSchemaUrl() {
		return schemaUrl;
	}


	public void setSchemaUrl(String schemaUrl) {
		this.schemaUrl = schemaUrl;
	}


	public String getSystemName() {
		return systemName;
	}


	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}


	public String getSystemCode() {
		return systemCode;
	}


	public void setSystemCode(String systemCode) {
		this.systemCode = systemCode;
	}


	


	public String getDescritpionSource() {
		return descritpionSource;
	}


	public void setDescritpionSource(String descritpionSource) {
		this.descritpionSource = descritpionSource;
	}


	public UserModel getUtilisateur() {
		return utilisateur;
	}


	public void setUtilisateur(UserModel utilisateur) {
		this.utilisateur = utilisateur;
	}


	public DataDestinationModel getDatadestination() {
		return datadestination;
	}


	public void setDatadestination(DataDestinationModel datadestination) {
		this.datadestination = datadestination;
	}

	public int getIdSourceprop() {
		return idSourceprop;
	}


	public void setIdSourceprop(int idSourceprop) {
		this.idSourceprop = idSourceprop;
	}


	@Override
	public String toString() {
		return "DataSourceModel [idSourceSequence=" + idSourceSequence + ", schemaUrl=" + schemaUrl + ", systemName="
				+ systemName + ", systemCode=" + systemCode + ", descritpion_Source=" + descritpionSource
				+ ", utilisateur=" + utilisateur + ", datadestination=" + datadestination + "]";
	}


	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DataSourceModel other = (DataSourceModel) obj;
		if (datadestination == null) {
			if (other.datadestination != null)
				return false;
		} else if (!datadestination.equals(other.datadestination))
			return false;
		if (descritpionSource == null) {
			if (other.descritpionSource != null)
				return false;
		} else if (!descritpionSource.equals(other.descritpionSource))
			return false;
		if (idSourceSequence != other.idSourceSequence)
			return false;
		if (schemaUrl == null) {
			if (other.schemaUrl != null)
				return false;
		} else if (!schemaUrl.equals(other.schemaUrl))
			return false;
		if (systemCode == null) {
			if (other.systemCode != null)
				return false;
		} else if (!systemCode.equals(other.systemCode))
			return false;
		if (systemName == null) {
			if (other.systemName != null)
				return false;
		} else if (!systemName.equals(other.systemName))
			return false;
		if (utilisateur == null) {
			if (other.utilisateur != null)
				return false;
		} else if (!utilisateur.equals(other.utilisateur))
			return false;
		return true;
	}


	

	
	
	
}
