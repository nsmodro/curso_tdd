package caixaEletronico;

import testesCaixaEletronico.ServicoRemoto;

public class ContaCorrente implements ServicoRemoto {
	
	private int numero;
	private Double saldo;
	private String numeroContaCartao;
	
	public ContaCorrente(int numero, Double saldo) {
		this.setNumero(numero);
		this.setSaldo(saldo); 
	}
	
	public ContaCorrente(int numero, Double saldo, String numeroContaCartao) {
		this.setNumero(numero);
		this.setSaldo(saldo); 
		this.setNumeroContaCartao(numeroContaCartao);
	}

	@Override
	public ContaCorrente recuperaConta(int numero) {
		ContaCorrente contaCorrente = new ContaCorrente(123, 600.00);
		return contaCorrente;
	}

	@Override
	public boolean persistirConta(ContaCorrente contaCorrente) {
		
		return true;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public String getNumeroContaCartao() {
		return numeroContaCartao;
	}

	public void setNumeroContaCartao(String numeroContaCartao) {
		this.numeroContaCartao = numeroContaCartao;
	}
	
}
