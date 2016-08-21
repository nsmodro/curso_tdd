package br.com.componente.testes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.com.componente.arquivo.Arquivo;
import br.com.componente.src.Armazenamento;
import br.com.componente.src.TipoPonto;
import br.com.componente.src.Usuario;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestesComponenteDeGamificacao {
	
	@Test
	public void teste1CriaArquivo() {
		Arquivo arquivo = new Arquivo("testeCriacao.txt");
		assertTrue(arquivo.existe("testeCriacao.txt"));
	}
	
	@Test
	public void teste2EscreveArquivo() {
		Arquivo arquivo = new Arquivo("testeCriacao2.txt");
		arquivo.escreve("escrevendo primeiro texto");
		assertEquals("escrevendo primeiro texto", arquivo.getTextoArquivo());
	}
	
	@Test
	public void teste3ArmazenarPonto() {
		Armazenamento armazenamento =  new Armazenamento();
		TipoPonto tipoPonto = new TipoPonto("estrela");
		Usuario usuario = new Usuario("guerra");
		armazenamento.armazena(usuario, tipoPonto, 10);
		assertEquals("GUERRA;ESTRELA;10;", armazenamento.getUltimoArmazenado());
	}
	
	@Test
	public void teste4RecuperaPontosPorUserETipoSituacao1() {
		Armazenamento armazenamento =  new Armazenamento();
		TipoPonto tipoPonto = new TipoPonto("estrela");
		Usuario usuario = new Usuario("guerra");
		assertEquals(10, armazenamento.getPontos(usuario, tipoPonto));
	}
	
	
	@Test
	public void testeRecuperaPontosPorUserETipoSituacao2() {
		Armazenamento armazenamento =  new Armazenamento();
		armazenamento.armazena(new Usuario("guerra"), new TipoPonto("estrela"), 10);
		armazenamento.armazena(new Usuario("guerra"), new TipoPonto("estrela"), 15);
		armazenamento.armazena(new Usuario("guerra"), new TipoPonto("moedas"), 42);
		armazenamento.armazena(new Usuario("bob"), new TipoPonto("estrela"), 12);
		armazenamento.getPontos(new Usuario("guerra"), new TipoPonto("estrela"));
		//assertEquals(35, armazenamento.getPontos(new Usuario("guerra"), new TipoPonto("estrela")));
	}
	
	/*
	//Armazenar que um usu�rio recebeu uma quantidade de um tipo de ponto. Por exemplo: o usu�rio "guerra" recebeu "10" pontos do tipo "estrela"
	//Recuperar quantos pontos de um tipo tem um usu�rio. Por exemplo: retornar quantos pontos do tipo "estrela" tem o usu�rio "guerra"
	@Test
	public void testeArmazenarPonto() {
		Armazenamento armazenamento =  new Armazenamento();
		TipoPonto tipoPonto = new TipoPonto("estrela");
		Usuario usuario = new Usuario("guerra");
		armazenamento.armazenaNovoPonto(usuario, tipoPonto, 10);
		assertEquals(10, armazenamento.getQtdePontos(usuario, tipoPonto));
	}
	
	@Test
	public void testeRetornaTodosUsuariosComPonto() {
		Armazenamento armazenamento =  new Armazenamento();
		TipoPonto tipoPonto = new TipoPonto("estrela");
		Usuario usuario = new Usuario("guerra");
		armazenamento.armazenaNovoPonto(usuario, tipoPonto, 10);
		assertEquals(10, armazenamento.getQtdePontos(usuario, tipoPonto));
	}
	
	
	
*/
}
