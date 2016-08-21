package br.com.componente.exception;

public class ArquivoJaExistenteException extends AssertionError {
	
	public ArquivoJaExistenteException(String mensagem) {
		super(mensagem);
	}

}
