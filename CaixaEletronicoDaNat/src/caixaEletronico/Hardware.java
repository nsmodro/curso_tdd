package caixaEletronico;

public interface Hardware {
	
	public String pegarNumeroDaContaCartao(int numero);
	
	public String login (int numero);
	
	public void entregarDinheiro();
	
	public void lerEnvelope();

}
