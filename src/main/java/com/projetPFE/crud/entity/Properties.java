package com.projetPFE.crud.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Properties {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idProperty;
	
	private String codeProp;
	private String propName;
	private String classe;
	
	
	@ManyToOne
	  @JoinColumn(name="sourceproperties")
	  private SourceProperties sourceproperties;

	public Properties() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Properties(int idProperty) {
		super();
		this.idProperty = idProperty;
	}



	public SourceProperties getSourceproperties() {
		return sourceproperties;
	}

    public void setSourceproperties(SourceProperties sourceproperties) {
		this.sourceproperties = sourceproperties;
	}


	public Properties(int idProperty, String codeProp, String propName, String classe,
			SourceProperties sourceproperties) {
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

}
