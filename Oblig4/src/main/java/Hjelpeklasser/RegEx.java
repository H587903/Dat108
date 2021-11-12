package Hjelpeklasser;

public class RegEx {
	
	public static boolean isValidFornavn(String s) {
		return s != null && s.matches("^[A-ZÆØÅ][a-zæøå]{1,19}$");	//Stor førstebokstav fleire små etter
	}
	
	public static boolean isValidEtternavn(String s) {
		return s != null && s.matches("^[A-ZÆØÅ][a-zæøå]{1,19}(?!\\S+$)$");	//Stor førstebokstav fleire små etter
	}
	
	public static boolean isValidMobilnummer(String s) {
		return s != null && s.matches("^\\d{8}$");		//Inneholder åtte tal
	}
	
	public static boolean isValidPassord(String s) {
		return s != null && s.matches("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,20}$"); //Må inneholde tal, små og store bokstavar og vere mellom 8 og 20 teikn langt
				}
}