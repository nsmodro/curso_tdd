package br.com.componente.src;

public class TipoPonto {
	
	private String tipoPonto;

	public TipoPonto(String tipoPonto) {
		this.tipoPonto = tipoPonto;
	}

	public String getTipoPonto() {
		return tipoPonto.toUpperCase();
	}

	public void setTipoPonto(String tipoPonto) {
		this.tipoPonto = tipoPonto;
	}

}
