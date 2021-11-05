package com.projetPFE.crud.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import com.fasterxml.jackson.annotation.JsonProperty;

@Document(indexName = "user_new", createIndex = true)

public class UserModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	//@JsonProperty("cin")

	@Field(type = FieldType.Text)
	private String cin;
	  // @JsonProperty("firstname")

	@Field(type = FieldType.Text)

	private String firstName;
	  // @JsonProperty("lastname")

	@Field(type = FieldType.Text)

	private String lastName;
	  // @JsonProperty("phone")

	@Field(type = FieldType.Text)

	private String phone;
	   //@JsonProperty("mail")

	@Field(type = FieldType.Text)

	private String mail;
	  // @JsonProperty("login")

	@Field(type = FieldType.Text)

	private String login;
	   //@JsonProperty("password")

	@Field(type = FieldType.Text)

	private String password;
	 //  @JsonProperty("role")

	@Field(type = FieldType.Text)

		
	private Role role;

	public UserModel() {
		
	}

	public UserModel(int id, String cin, String firstName, String lastName, String phone, String mail, String login,
			String password, Role role) {
		super();
		this.id = id;
		this.cin = cin;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.mail = mail;
		this.login = login;
		this.password = password;
		this.role = role;
	}

	public UserModel(String firstName2, int id2, String lastName2) {
		// TODO Auto-generated constructor stub
		this.firstName = firstName;
		this.id = id;

		this.lastName = lastName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserModel [id=" + id + ", cin=" + cin + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", phone=" + phone + ", mail=" + mail + ", login=" + login + ", password=" + password + ", role="
				+ role + "]";
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserModel other = (UserModel) obj;
		if (cin == null) {
			if (other.cin != null)
				return false;
		} else if (!cin.equals(other.cin))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id != other.id)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (mail == null) {
			if (other.mail != null)
				return false;
		} else if (!mail.equals(other.mail))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (role != other.role)
			return false;
		return true;
	}



	

	
	 
	

}
