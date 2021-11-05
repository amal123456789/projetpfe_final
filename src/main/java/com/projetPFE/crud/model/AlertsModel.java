package com.projetPFE.crud.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
@Document(indexName = "alertskibana", createIndex = true)
public class AlertsModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
private int id ;
	@Field(type = FieldType.Text)
private String name;
	@Field(type = FieldType.Text)
private String action;
	@Field(type = FieldType.Text)
private String message;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public AlertsModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AlertsModel(int id, String name, String action, String message) {
		super();
		this.id = id;
		this.name = name;
		this.action = action;
		this.message = message;
	}
	@Override
	public String toString() {
		return "AlertsModel [id=" + id + ", name=" + name + ", action=" + action + ", message=" + message + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AlertsModel other = (AlertsModel) obj;
		if (action == null) {
			if (other.action != null)
				return false;
		} else if (!action.equals(other.action))
			return false;
		if (id != other.id)
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
}
