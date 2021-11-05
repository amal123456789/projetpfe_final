package com.projetPFE.crud.model;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Document(indexName = "logs_new", createIndex = true)
public class LogsModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Field(type = FieldType.Date, format = DateFormat.custom, pattern = "yyyy-MM-dd'T'hh:mm:ss.SSS'Z'")
	private Date d_log;
	@Field(type = FieldType.Text)
	private String type;
	@Field(type = FieldType.Text)
	private String sens;
	@Field(type = FieldType.Text)
	private String ws;
	@Field(type = FieldType.Text)
	private String methode;
	@Field(type = FieldType.Text)
	private String sys_appelant;
	@Field(type = FieldType.Text)
	private String c_retour;
	@Field(type = FieldType.Text)
	private String operation;
	@Field(type = FieldType.Text)
	private String txt_log;
	@Field(type = FieldType.Text)
	private String request;
	@Field(type = FieldType.Text)
	private String response;
	@Field(type = FieldType.Integer)
	private int id_dem;
	@Field(type = FieldType.Text)
	private String bpm_uid;
	@Field(type = FieldType.Text)
	private String ref_dem_src;

	public LogsModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public LogsModel(int id, Date d_log, String type, String sens, String ws, String methode, String sys_appelant,
			String c_retour, String operation, String txt_log, String request, String response, int id_dem,
			String bpm_uid, String ref_dem_src) {
		super();
		this.id = id;
		this.d_log = d_log;
		this.type = type;
		this.sens = sens;
		this.ws = ws;
		this.methode = methode;
		this.sys_appelant = sys_appelant;
		this.c_retour = c_retour;
		this.operation = operation;
		this.txt_log = txt_log;
		this.request = request;
		this.response = response;
		this.id_dem = id_dem;
		this.bpm_uid = bpm_uid;
		this.ref_dem_src = ref_dem_src;
	}





	public int getId() {
		return id;
	}

	public void setId(int idLog) {
		this.id = id;
	}

	

	public Date getD_log() {
		return d_log;
	}



	public void setD_log(Date d_log) {
		this.d_log = d_log;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public String getSens() {
		return sens;
	}



	public void setSens(String sens) {
		this.sens = sens;
	}



	public String getWs() {
		return ws;
	}



	public void setWs(String ws) {
		this.ws = ws;
	}



	public String getMethode() {
		return methode;
	}



	public void setMethode(String methode) {
		this.methode = methode;
	}



	public String getSys_appelant() {
		return sys_appelant;
	}



	public void setSys_appelant(String sys_appelant) {
		this.sys_appelant = sys_appelant;
	}



	public String getC_retour() {
		return c_retour;
	}



	public void setC_retour(String c_retour) {
		this.c_retour = c_retour;
	}



	public String getOperation() {
		return operation;
	}



	public void setOperation(String operation) {
		this.operation = operation;
	}



	public String getTxt_log() {
		return txt_log;
	}



	public void setTxt_log(String txt_log) {
		this.txt_log = txt_log;
	}



	public String getRequest() {
		return request;
	}



	public void setRequest(String request) {
		this.request = request;
	}



	public String getResponse() {
		return response;
	}



	public void setResponse(String response) {
		this.response = response;
	}



	public int getId_dem() {
		return id_dem;
	}



	public void setId_dem(int id_dem) {
		this.id_dem = id_dem;
	}



	public String getBpm_uid() {
		return bpm_uid;
	}



	public void setBpm_uid(String bpm_uid) {
		this.bpm_uid = bpm_uid;
	}



	public String getRef_dem_src() {
		return ref_dem_src;
	}



	public void setRef_dem_src(String ref_dem_src) {
		this.ref_dem_src = ref_dem_src;
	}



	public String getREF_DEM_SRC() {
		return ref_dem_src;
	}

	public void setREF_DEM_SRC(String rEF_DEM_SRC) {
		this.ref_dem_src = rEF_DEM_SRC;
	}



	@Override
	public String toString() {
		return "LogsModel [id=" + id + ", d_log=" + d_log + ", type=" + type + ", sens=" + sens + ", ws=" + ws
				+ ", methode=" + methode + ", sys_appelant=" + sys_appelant + ", c_retour=" + c_retour + ", operation="
				+ operation + ", txt_log=" + txt_log + ", request=" + request + ", response=" + response + ", id_dem="
				+ id_dem + ", bpm_uid=" + bpm_uid + ", ref_dem_src=" + ref_dem_src + "]";
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LogsModel other = (LogsModel) obj;
		if (bpm_uid == null) {
			if (other.bpm_uid != null)
				return false;
		} else if (!bpm_uid.equals(other.bpm_uid))
			return false;
		if (c_retour == null) {
			if (other.c_retour != null)
				return false;
		} else if (!c_retour.equals(other.c_retour))
			return false;
		if (d_log == null) {
			if (other.d_log != null)
				return false;
		} else if (!d_log.equals(other.d_log))
			return false;
		if (id_dem != other.id_dem)
			return false;
		if (methode == null) {
			if (other.methode != null)
				return false;
		} else if (!methode.equals(other.methode))
			return false;
		if (operation == null) {
			if (other.operation != null)
				return false;
		} else if (!operation.equals(other.operation))
			return false;
		if (ref_dem_src == null) {
			if (other.ref_dem_src != null)
				return false;
		} else if (!ref_dem_src.equals(other.ref_dem_src))
			return false;
		if (request == null) {
			if (other.request != null)
				return false;
		} else if (!request.equals(other.request))
			return false;
		if (response == null) {
			if (other.response != null)
				return false;
		} else if (!response.equals(other.response))
			return false;
		if (sens == null) {
			if (other.sens != null)
				return false;
		} else if (!sens.equals(other.sens))
			return false;
		if (sys_appelant == null) {
			if (other.sys_appelant != null)
				return false;
		} else if (!sys_appelant.equals(other.sys_appelant))
			return false;
		if (txt_log == null) {
			if (other.txt_log != null)
				return false;
		} else if (!txt_log.equals(other.txt_log))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (ws == null) {
			if (other.ws != null)
				return false;
		} else if (!ws.equals(other.ws))
			return false;
		if (id != other.id)
			return false;
		return true;
	}

}
