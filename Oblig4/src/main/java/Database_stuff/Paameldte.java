package Database_stuff;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.servlet.http.HttpServletRequest;

import Hjelpeklasser.PassordUtil;

@Entity
@Table(schema = "oblig4")
public class Paameldte {
	
	@Id
	private String mobil;
	private String fornavn;
	private String etternavn;
	private String passord;
	private String kjonn;
	private String salt;
	
	public Paameldte() {
		
	}
	
	public Paameldte(HttpServletRequest request) {
		this.fornavn = request.getParameter("fornavn");
		this.etternavn = request.getParameter("etternavn");
		this.mobil = request.getParameter("mobil");
		this.salt = PassordUtil.genererTilfeldigSalt();
		this.passord = PassordUtil.hashMedSalt(request.getParameter("passord"), this.salt);
		this.kjonn = request.getParameter("kjonn");
	}
	
	public String getFornavn() {
		return fornavn;
	}
	
	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}
	
	public String getEtternavn() {
		return etternavn;
	}
	
	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}
	
	public String getMobil() {
		return mobil;
	}
	
	public void setMobil(String mobil) {
		this.mobil = mobil;
	}
	
	public String getPassord() {
		return passord;
	}

	public void setPassord(String passord) {
		this.passord = passord;
	}
	
	public String getKjonn() {
		return kjonn;
	}
	
	public void setKjonn(String kjonn) {
		this.kjonn = kjonn;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	@Override
	public String toString() {
		return "Paameldte [mobil=" + mobil + ", fornavn=" + fornavn + ", etternavn=" + etternavn
				+ ", passord=" + passord + ", kjonn=" + kjonn + "]";
	}
}
