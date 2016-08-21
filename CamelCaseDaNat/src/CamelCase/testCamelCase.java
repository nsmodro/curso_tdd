package CamelCase;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Natacha Modro
 * 
 * Relat�rio processo TDD
 * 
 * 1� Ciclo: 
 * 		-criar teste stringEmpty();
 * 		-Criar Classe CamelCase e m�todo converterCamelCase.
 * 2� Ciclo:
 * 		-adicionar @Before para instanciar o objeto CamelCase;
 * 		-criar teste allLowerCase();
 * 		-alterar m�todo converterCamelCase para que retorno passe no teste.
 * 3� Ciclo:
 * 		-criar teste firstLetterUpperCase();
 * 		-alterar m�todo converterCamelCase para que retorno passe no teste.
 * 4� Ciclo: 
 *		-criar teste splitOnLetterUpperCase();
 *		-alterar m�todo converterCamelCase para que retorno passe no teste. 
 * 5� Ciclo:
 *		-alterar teste splitOnLetterUpperCase() para entrada ex: "TesteTeste";
 *		-Passou no teste sem alterar o m�todo.
 * 6� Ciclo:
 *		-criar teste allUpperCase(); 
 *		-alterar m�todo converterCamelCase para que retorno passe no teste.
 * 7� Ciclo:
 * 		-criar teste testWordWithUpperCase();
 * 		-alterar m�todo converterCamelCase para que retorno passe no teste.
 * 8� Ciclo:
 * 		-alterar teste testWordWithUpperCase() para entrada ex: "TesteTESTETeste";
 * 		-Passou no teste sem alterar o  m�todo.
 * 9� Ciclo: 
 * 		-criar teste withNumberBetweenWords();
 * 		-alterar m�todo converterCamelCase para que retorno passe no teste.
 * 10� Ciclo: 
 * 		-criar teste startsWithNumber() com exception;
 * 		-criar classe de exception;
 * 		-alterar m�todo converterCamelCase para que retorno passe no teste.
 * 11� Ciclo: 
 * 		-criar teste specialCharacter();
 * 		-criar classe de exception;
 * 		-alterar m�todo converterCamelCase para que retorno passe no teste.
 */
public class testCamelCase {
	
	CamelCase camelCase;
	
	@Before
	public void init() {
		camelCase = new CamelCase();
	}

	@Test
	public void stringEmpty() {
		assertNull(camelCase.converterCamelCase(""));
	}
	
	@Test
	public void allLowerCase() {
		assertEquals("nome", camelCase.converterCamelCase("nome").get(0));
	}
	
	@Test
	public void firstLetterUpperCase() {
		assertEquals("nome", camelCase.converterCamelCase("Nome").get(0));
	}
	
	@Test
	public void splitOnLetterUpperCase() {
		List<String> expected = Arrays.asList("nome", "composto");
		
		//4� Ciclo
		assertEquals(expected, camelCase.converterCamelCase("nomeComposto"));
		
		//5� Ciclo
		assertEquals(expected, camelCase.converterCamelCase("NomeComposto"));
	}
	
	@Test
	public void allUpperCase() {
		List<String> expected = Arrays.asList("CPF");
		assertEquals(expected, camelCase.converterCamelCase("CPF"));
	}
	
	@Test
	public void testWordWithUpperCase() {
		List<String> expected = Arrays.asList("numero", "CPF");
		assertEquals(expected, camelCase.converterCamelCase("numeroCPF"));
		
		List<String> expected1 = Arrays.asList("numero", "CPF", "contribuinte");
		
		assertEquals(expected1, camelCase.converterCamelCase("numeroCPFContribuinte"));	
	}
	
	@Test
	public void withNumberBetweenWords() {
		List<String> expected = Arrays.asList("recupera", "10", "primeiros");
		assertEquals(expected, camelCase.converterCamelCase("recupera10Primeiros"));
	}
	
	@Test(expected=StartsWithNumberException.class)
	public void startsWithNumber(){
		camelCase.converterCamelCase("10Primeiros");
	}
	
	@Test(expected=SpecialCharacterException.class)
	public void specialCharacter(){
		camelCase.converterCamelCase("nome#Composto");
	}

}
