package testesCaixaEletronico;

import caixaEletronico.ContaCorrente;

public class MockServicoRemoto implements ServicoRemoto{
	
	@Override
	public ContaCorrente recuperaConta(int numero) {
		ContaCorrente contaCorrente = new ContaCorrente(123, 600.00);
		return contaCorrente;
	}

	@Override
	public boolean persistirConta(ContaCorrente contaCorrente) {
		return true;
	}


}
