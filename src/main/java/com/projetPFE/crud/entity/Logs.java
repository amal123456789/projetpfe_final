package com.projetPFE.crud.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Logs {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")

	private Date D_LOG;
	private String TYPE;
	private String SENS;
	private String WS;
	private String METHODE;
	private String SYS_APPELANT;
	private String C_RETOUR;
	private String OPERATION;
	private String TXT_LOG;
	private String REQUEST;
	private String RESPONSE;
	@Column(nullable = true)
	private int ID_DEM;
	private String BPM_UID;
	private String REF_DEM_SRC;
	public Logs() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Logs(int iD_LOG, Date d_LOG, String tYPE, String sENS, String wS, String mETHODE, String sYS_APPELANT,
			String c_RETOUR, String oPERATION, String tXT_LOG, String rEQUEST, String rESPONSE, int iD_DEM,
			String bPM_UID, String rEF_DEM_SRC) {
		super();
		id= iD_LOG;
		D_LOG = d_LOG;
		TYPE = tYPE;
		SENS = sENS;
		WS = wS;
		METHODE = mETHODE;
		SYS_APPELANT = sYS_APPELANT;
		C_RETOUR = c_RETOUR;
		OPERATION = oPERATION;
		TXT_LOG = tXT_LOG;
		REQUEST = rEQUEST;
		RESPONSE = rESPONSE;
		ID_DEM = iD_DEM;
		BPM_UID = bPM_UID;
		REF_DEM_SRC = rEF_DEM_SRC;
	}
	public int getId() {
		return id;
	}
	public void setId(int iD_LOG) {
		id = iD_LOG;
	}
	public Date getD_LOG() {
		return D_LOG;
	}
	public void setD_LOG(Date d_LOG) {
		D_LOG = d_LOG;
	}
	public String getTYPE() {
		return TYPE;
	}
	public void setTYPE(String tYPE) {
		TYPE = tYPE;
	}
	public String getSENS() {
		return SENS;
	}
	public void setSENS(String sENS) {
		SENS = sENS;
	}
	public String getWS() {
		return WS;
	}
	public void setWS(String wS) {
		WS = wS;
	}
	public String getMETHODE() {
		return METHODE;
	}
	public void setMETHODE(String mETHODE) {
		METHODE = mETHODE;
	}
	public String getSYS_APPELANT() {
		return SYS_APPELANT;
	}
	public void setSYS_APPELANT(String sYS_APPELANT) {
		SYS_APPELANT = sYS_APPELANT;
	}
	public String getC_RETOUR() {
		return C_RETOUR;
	}
	public void setC_RETOUR(String c_RETOUR) {
		C_RETOUR = c_RETOUR;
	}
	public String getOPERATION() {
		return OPERATION;
	}
	public void setOPERATION(String oPERATION) {
		OPERATION = oPERATION;
	}
	public String getTXT_LOG() {
		return TXT_LOG;
	}
	public void setTXT_LOG(String tXT_LOG) {
		TXT_LOG = tXT_LOG;
	}
	public String getREQUEST() {
		return REQUEST;
	}
	public void setREQUEST(String rEQUEST) {
		REQUEST = rEQUEST;
	}
	public String getRESPONSE() {
		return RESPONSE;
	}
	public void setRESPONSE(String rESPONSE) {
		RESPONSE = rESPONSE;
	}
	public int getID_DEM() {
		return ID_DEM;
	}
	public void setID_DEM(int iD_DEM) {
		ID_DEM = iD_DEM;
	}
	public String getBPM_UID() {
		return BPM_UID;
	}
	public void setBPM_UID(String bPM_UID) {
		BPM_UID = bPM_UID;
	}
	public String getREF_DEM_SRC() {
		return REF_DEM_SRC;
	}
	public void setREF_DEM_SRC(String rEF_DEM_SRC) {
		REF_DEM_SRC = rEF_DEM_SRC;
	}
	@Override
	public String toString() {
		return "Logs [ID_LOG=" + id + ", D_LOG=" + D_LOG + ", TYPE=" + TYPE + ", SENS=" + SENS + ", WS=" + WS
				+ ", METHODE=" + METHODE + ", SYS_APPELANT=" + SYS_APPELANT + ", C_RETOUR=" + C_RETOUR + ", OPERATION="
				+ OPERATION + ", TXT_LOG=" + TXT_LOG + ", REQUEST=" + REQUEST + ", RESPONSE=" + RESPONSE + ", ID_DEM="
				+ ID_DEM + ", BPM_UID=" + BPM_UID + ", REF_DEM_SRC=" + REF_DEM_SRC + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Logs other = (Logs) obj;
		if (BPM_UID == null) {
			if (other.BPM_UID != null)
				return false;
		} else if (!BPM_UID.equals(other.BPM_UID))
			return false;
		if (C_RETOUR == null) {
			if (other.C_RETOUR != null)
				return false;
		} else if (!C_RETOUR.equals(other.C_RETOUR))
			return false;
		if (D_LOG == null) {
			if (other.D_LOG != null)
				return false;
		} else if (!D_LOG.equals(other.D_LOG))
			return false;
		if (ID_DEM != other.ID_DEM)
			return false;
		if (id != other.id)
			return false;
		if (METHODE == null) {
			if (other.METHODE != null)
				return false;
		} else if (!METHODE.equals(other.METHODE))
			return false;
		if (OPERATION == null) {
			if (other.OPERATION != null)
				return false;
		} else if (!OPERATION.equals(other.OPERATION))
			return false;
		if (REF_DEM_SRC == null) {
			if (other.REF_DEM_SRC != null)
				return false;
		} else if (!REF_DEM_SRC.equals(other.REF_DEM_SRC))
			return false;
		if (REQUEST == null) {
			if (other.REQUEST != null)
				return false;
		} else if (!REQUEST.equals(other.REQUEST))
			return false;
		if (RESPONSE == null) {
			if (other.RESPONSE != null)
				return false;
		} else if (!RESPONSE.equals(other.RESPONSE))
			return false;
		if (SENS == null) {
			if (other.SENS != null)
				return false;
		} else if (!SENS.equals(other.SENS))
			return false;
		if (SYS_APPELANT == null) {
			if (other.SYS_APPELANT != null)
				return false;
		} else if (!SYS_APPELANT.equals(other.SYS_APPELANT))
			return false;
		if (TXT_LOG == null) {
			if (other.TXT_LOG != null)
				return false;
		} else if (!TXT_LOG.equals(other.TXT_LOG))
			return false;
		if (TYPE == null) {
			if (other.TYPE != null)
				return false;
		} else if (!TYPE.equals(other.TYPE))
			return false;
		if (WS == null) {
			if (other.WS != null)
				return false;
		} else if (!WS.equals(other.WS))
			return false;
		return true;
	}
	
	
	
	
	

}
