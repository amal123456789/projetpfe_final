package com.projetPFE.crud.entity;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;


@Entity
//@Document(indexName = "dataSource", shards = 1, replicas = 0, refreshInterval = "5s", createIndex = true)

public class DataSource {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idSourceSequence;
    private String schemaUrl;
    private String systemName;
	private String systemCode;
    private String descritpionSource;
	@ManyToOne
	  @JoinColumn(name="user")
	  private User utilisateur;

	
	@ManyToOne
	  @JoinColumn(name="datadestination")
	  private DataDestination datadestination;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idSourceprop", nullable = false)
    private SourceProperties sourceprop;
	@Transient
	private int idSourceprop;
	
	public DataSource() {
		
	}


	public DataSource(int idSourceSequence, String schemaUrl, String systemName, String systemCode,
			String descritpionSource, User utilisateur, DataDestination datadestination) {
		super();
		this.idSourceSequence = idSourceSequence;
		this.schemaUrl = schemaUrl;
		this.systemName = systemName;
		this.systemCode = systemCode;
		this.descritpionSource = descritpionSource;
		this.utilisateur = utilisateur;
		this.datadestination = datadestination;
	}


	public SourceProperties getSourceprop() {
		return sourceprop;
	}


	public void setSourceprop(SourceProperties sourceprop) {
		this.sourceprop = sourceprop;
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


	public User getUtilisateur() {
		return utilisateur;
	}


	public void setUtilisateur(User utilisateur) {
		this.utilisateur = utilisateur;
	}


	public DataDestination getDatadestination() {
		return datadestination;
	}


	public void setDatadestination(DataDestination datadestination) {
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
		return "DataSource [idSourceSequence=" + idSourceSequence + ", schemaUrl=" + schemaUrl + ", systemName="
				+ systemName + ", systemCode=" + systemCode + ", descritpionSource=" + descritpionSource
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
		DataSource other = (DataSource) obj;
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
