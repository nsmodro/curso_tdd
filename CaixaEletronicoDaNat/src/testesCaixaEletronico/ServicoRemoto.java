package testesCaixaEletronico;

import caixaEletronico.ContaCorrente;

public interface ServicoRemoto {
	
	public ContaCorrente recuperaConta(int numero);
	
	public boolean persistirConta(ContaCorrente contaCorrente);

}
