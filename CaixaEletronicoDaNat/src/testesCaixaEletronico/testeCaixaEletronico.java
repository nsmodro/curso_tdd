package testesCaixaEletronico;

import static org.junit.Assert.*;

import org.junit.Test;

import caixaEletronico.CaixaEletronico;
import caixaEletronico.ContaCorrente;

public class testeCaixaEletronico {
	
	@Test
	public void adicionaContaCorrente() {
		ContaCorrente cc = new ContaCorrente(123, 600.00);
		assertEquals(123, cc.getNumero());
		assertEquals((Double)600.00, cc.getSaldo());
	}
	
	@Test
	public void testePersistirConta() {
		CaixaEletronico ce = new CaixaEletronico();
		ContaCorrente cc = new ContaCorrente(123, 200.00);
		ce.depositar(cc.getNumero(), cc.getSaldo());
		MockServicoRemoto mock = new MockServicoRemoto();
		assertTrue(mock.persistirConta(cc)); 
	}
	
	@Test
	public void testeSaldo() {
		CaixaEletronico ce = new CaixaEletronico();
		assertEquals("O saldo é R$ 600.0", ce.saldo(123));
	}
	
	@Test
	public void testeSacar() {
		CaixaEletronico ce = new CaixaEletronico();
		assertEquals("Retire seu dinheiro", ce.sacar(123, 200.00));
		assertEquals("Saldo insuficiente", ce.sacar(123, 700.00));
	}
	
	@Test
	public void testeDepositar() {
		CaixaEletronico ce = new CaixaEletronico();
		assertEquals("Depósito recebido com sucesso", ce.depositar(123, 200.00));
	}
	
	@Test
	public void testeLogin() {
		CaixaEletronico ce = new CaixaEletronico();
		assertEquals("Usuário Autenticado", ce.login(123));
		assertEquals("Não foi possível autenticar o usuário", ce.login(124));
	}
	
	@Test
	public void testeInterfaceHardwareOK() {
		CaixaEletronico ce = new CaixaEletronico();
		ContaCorrente cc = new ContaCorrente(123, 600.00, "123456");
		assertEquals("123456", ce.pegarNumeroDaContaCartao(cc.getNumero()));
		ce.entregarDinheiro();
		ce.lerEnvelope();
	}
	
	@Test
	public void testeInterfaceHardwareNaoOK() {
		CaixaEletronico ce = new CaixaEletronico();
		ce.erro = true;
		ce.entregarDinheiro();
		ce.lerEnvelope();
	}


}
