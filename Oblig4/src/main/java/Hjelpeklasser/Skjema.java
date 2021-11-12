package Hjelpeklasser;

import javax.servlet.http.HttpServletRequest;


public class Skjema {
	
	private String fornavn;
	private String etternavn;
	private String mobil;
	private String passord;
	private String passordRepetert;
	private String kjonn;
	private String fornavnFeil;
	private String etternavnFeil;
	private String mobilFeil;
	private String passordFeil;
	private String passordRepetertFeil;
	private String kjonnFeil;
	
	public Skjema(HttpServletRequest request) {
		this.fornavn = escapeHtml(request.getParameter("fornavn"));
		this.etternavn = escapeHtml(request.getParameter("etternavn"));
		this.mobil = escapeHtml(request.getParameter("mobil"));
		this.passord = escapeHtml(request.getParameter("passord"));
		this.passordRepetert = escapeHtml(request.getParameter("passordRepetert"));
		this.kjonn = request.getParameter("kjonn");
	}
	
	private String escapeHtml(String s) {
		String resultat = s;
		resultat = resultat.replaceAll("<", "&lt;");
		resultat = resultat.replaceAll(">", "&gt;");
		resultat = resultat.replaceAll("\"", "&quot;");
		//...
		return resultat;
	}
	
	
	public boolean isAllInputGyldig() {
		return isFornavnGyldig() && isEtternavnGyldig() && isMobilGyldig() &&
				isPassordGyldig() && isRepetertPassordGyldig() && isKjonnGyldig();
	}
	
	private boolean isFornavnGyldig() {
		return RegEx.isValidFornavn(fornavn);
	}
	
	private boolean isEtternavnGyldig() {
		return RegEx.isValidEtternavn(etternavn);
	}
	
	private boolean isMobilGyldig() {
		return RegEx.isValidMobilnummer(mobil);
	}
	
	private boolean isPassordGyldig() {
		return RegEx.isValidPassord(passord);
	}
	
	private boolean isRepetertPassordGyldig() {
		return passordRepetert.equals(passord);
	}
	
	private boolean isKjonnGyldig() {
		if(kjonn != null && kjonn != "") {
			return true;
		}
		return false;
	}
	
	public void feilmeldinger() {
		if(!isFornavnGyldig()) {
			fornavn = "";
			fornavnFeil = "Ugyldig fornavn";
		}
		if(!isEtternavnGyldig()) {
			etternavn = "";
			etternavnFeil = "Ugyldig etternavn";
		}
		if(!isMobilGyldig()) {
			mobil = "";
			mobilFeil = "Ugyldig mobilnummer";
		}
		if(!isPassordGyldig()) {
			passord = "";
			passordFeil = "Ugyldig passord";
		}
		if(!isRepetertPassordGyldig()) {
			passordRepetert = "";
			passordRepetertFeil = "Er ikkje likt passord";
		}
		if(!isKjonnGyldig()) {
			kjonn = "";
			kjonnFeil = "Du må velge eit kjonn";
		}
	}

	public String getFornavn() {
		return fornavn;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public String getMobil() {
		return mobil;
	}

	public String getPassord() {
		return passord;
	}

	public String getPassordRepetert() {
		return passordRepetert;
	}

	public String getKjonn() {
		return kjonn;
	}

	public String getFornavnFeil() {
		return fornavnFeil;
	}

	public String getEtternavnFeil() {
		return etternavnFeil;
	}

	public String getMobilFeil() {
		return mobilFeil;
	}

	public String getPassordFeil() {
		return passordFeil;
	}

	public String getPassordRepetertFeil() {
		return passordRepetertFeil;
	}

	public String getKjonnFeil() {
		return kjonnFeil;
	}
	
	public void setMobilFeil(String mobilFeil) {
		this.mobilFeil = mobilFeil;
	}
}
