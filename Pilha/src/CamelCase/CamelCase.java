package CamelCase;

import java.util.ArrayList;
import java.util.List;

public class CamelCase {

	public List<String> converterCamelCase(String stringOriginal) {
		List<String> listConverterCamelCase = new ArrayList<String>();
		if (stringOriginal.isEmpty()) {
			return null;
		} else if (validaString(stringOriginal)) {
			for (String string : splitString(stringOriginal)) {
				listConverterCamelCase.add(trataString(string));
			}
		}
		return listConverterCamelCase;
	}
	
	public boolean validaString(String stringOriginal) {
		if (Character.isDigit(stringOriginal.charAt(0))) {
			throw new StartsWithNumberException("Não deve começar com números");
		} 
		if (!stringOriginal.matches("[a-zA-Z0-9]*")) {
			throw new SpecialCharacterException("Caracteres especiais não são permitidos, somente letras e números");
		}
		return true;
	}
	
	public String[] splitString(String stringOriginal){
		return stringOriginal.split("(?<=[a-z])(?=[A-Z])|(?<=[A-Z])(?=[A-Z][a-z])|(?=[A-Z][a-z])|(?<=\\d)(?=\\D)|(?=\\d)(?<=\\D)");
	}
	
	public String trataString(String string) {
		if (string.matches("^[A-Z]*$")) {
			return string;
		} else {
			return string.toLowerCase();
		}
	}
	
}
