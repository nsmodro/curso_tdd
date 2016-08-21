import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


/**
 * @author Natacha Modro
 * 
 * 1 - Tradutor sem palavras
 * 2 - Uma tradução
 * 3 - Duas traduções
 * 4 - Duas traduções, mesma palavra
 * 5 - Traduzir frase
 */
public class testeTradutor {
	
	Tradutor tradutor;
	
	@Before
	public void criarTradutor() {
		tradutor = new Tradutor();
	}

	@Test
	public void tradutorSemPalavras() {
		assertTrue(tradutor.estaVazio());
	}
	
	@Test
	public void umaTraducao() {
		tradutor.adicionaTraducao("bom", "good");
		assertFalse(tradutor.estaVazio());
		assertEquals("good", tradutor.traduzir("bom"));
	}
	
	@Test
	public void duasTraducoes() {
		tradutor.adicionaTraducao("bom", "good");
		tradutor.adicionaTraducao("mau", "bad");
		assertEquals("good", tradutor.traduzir("bom"));
		assertEquals("bad", tradutor.traduzir("mau"));
	}
	
	@Test
	public void duasTraducoesMesmaPalavra() {
		tradutor.adicionaTraducao("bom", "good");
		tradutor.adicionaTraducao("bom", "nice");
		assertEquals("good, nice", tradutor.traduzir("bom"));
	}
	
	@Test
	public void traduzirFrase() {
		tradutor.adicionaTraducao("guerra", "war");
		tradutor.adicionaTraducao("é", "is");
		tradutor.adicionaTraducao("ruim", "bad");
		assertEquals("war is bad", tradutor.traduzirFrase("guerra é ruim"));
	}
	
	@Test
	public void traduzirFraseDuasComTraducoesMesmaPalavra() {
		tradutor.adicionaTraducao("paz", "peace");
		tradutor.adicionaTraducao("é", "is");
		tradutor.adicionaTraducao("bom", "good");
		tradutor.adicionaTraducao("bom", "nice");
		assertEquals("peace is good", tradutor.traduzirFrase("paz é bom"));
	}

}
