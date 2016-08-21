package caixaEletronico;

import testesCaixaEletronico.MockServicoRemoto;

public class CaixaEletronico implements Hardware{
	
	public ContaCorrente cc = new ContaCorrente(123, 600.00, "123456");
	public MockServicoRemoto mockServicoRemoto = new MockServicoRemoto();
	public boolean erro = false;

	public String login(int numero) {
		cc = mockServicoRemoto.recuperaConta(numero);
		if (cc.getNumero() == numero) {
			return "Usu�rio Autenticado";
		} else {
			return "N�o foi poss�vel autenticar o usu�rio";
		}	
	}

	public String sacar(int numero, double valor) {	
		cc = mockServicoRemoto.recuperaConta(numero);
		if (cc.getSaldo() < valor) {
			return "Saldo insuficiente";
		} else {
			cc.setSaldo(cc.getSaldo() - valor);
			mockServicoRemoto.persistirConta(cc);
			return "Retire seu dinheiro";
		}		
	}

	public String saldo(int numero) {
		cc = mockServicoRemoto.recuperaConta(123);
		return "O saldo � R$ " + cc.getSaldo();
	}

	public String depositar(int numero, Double valor) {
		cc = mockServicoRemoto.recuperaConta(numero);
		cc.setSaldo(cc.getSaldo() + valor);
		if (mockServicoRemoto.persistirConta(cc)) {
			return "Dep�sito recebido com sucesso";
		}
		return "ERRO";
	}

	@Override
	public String pegarNumeroDaContaCartao(int numero) {
		return cc.getNumeroContaCartao();
	}

	@Override
	public void entregarDinheiro() {
		if (erro) {
			throw new RuntimeException("Erro");
		}
	}

	@Override
	public void lerEnvelope() {
		if (erro) {
			throw new RuntimeException("Erro");
		}

	}	

}
