package br.com.componente.src;

public class Usuario {
	
	private String nomeUsuario;

	public Usuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getNomeUsuario() {
		return nomeUsuario.toUpperCase();
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

}
