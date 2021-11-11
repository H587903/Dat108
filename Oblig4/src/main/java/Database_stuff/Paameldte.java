package Database_stuff;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "oblig4")
public class Paameldte {
	
	@Id
	private String mobil;
	private String fornavn;
	private String etternavn;
	private String passord;
	private String kjonn;
	
//	public Paameldte() {
//		
//	}
//	
//	public Paameldte(String fornavn, String etternavn, String mobil, String passord, String kjonn) {
//		this.fornavn = fornavn;
//		this.etternavn = etternavn;
//		this.mobil = mobil;
//		this.passord = passord;
//		this.kjonn = kjonn;
//	}
//	
//	public String getFornavn() {
//		return fornavn;
//	}
//	
//	public void setFornavn(String fornavn) {
//		this.fornavn = fornavn;
//	}
//	
//	public String getEtternavn() {
//		return etternavn;
//	}
//	
//	public void setEtternavn(String etternavn) {
//		this.etternavn = etternavn;
//	}
//	
//	public String getMobil() {
//		return mobil;
//	}
//	
//	public void setMobil(String mobil) {
//		this.mobil = mobil;
//	}
//
//	public void setPassord(String passord) {
//		this.passord = passord;
//	}
//	
//	public String getKjonn() {
//		return kjonn;
//	}
//	
//	public void setKjonn(String kjonn) {
//		this.kjonn = kjonn;
//	}
//	
//	@Override
//	public String toString() {
//		return "Paameldte [mobil=" + mobil + ", fornavn=" + fornavn + ", etternavn=" + etternavn
//				+ ", passord=" + passord + ", kjonn=" + kjonn + "]";
//	}
}
