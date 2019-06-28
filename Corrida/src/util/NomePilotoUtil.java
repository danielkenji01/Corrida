package util;

public class NomePilotoUtil {

	public static String pegarNomePiloto(String linha) {
		
		String nome = "";
		
		for (int i = 0; i < linha.length(); i++) {
			try {
				Double.parseDouble(String.valueOf(linha.charAt(i)));
				break;
			} catch (NumberFormatException e) {
				nome += linha.charAt(i);
			}
		}
		
		return nome;
	}
	
}
