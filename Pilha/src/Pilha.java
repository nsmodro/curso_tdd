
public class Pilha {
	
	private Object[] elementos;
	private int quantidade = 0;

	public Pilha(int maximo) {
		elementos = new Object[maximo];
	}

	public boolean estaVazia() {
		return (this.quantidade == 0);
	}

	public Object tamanho() {
		return this.quantidade;
	}

	public void empilha(Object elemento) {
		if (this.quantidade == elementos.length) {
			throw new PilhaCheiaException("N�o � poss�vel empilhar mais elementos");
		}
		this.elementos[this.quantidade] = elemento;
		this.quantidade++;
	}

	public Object topo() {
		return this.elementos[this.quantidade-1];
	}

	public Object desempilha() {
		
		if (estaVazia()) {
			throw new PilhaVaziaException("N�o � possivel desempilhar");
		}
		
		Object topo = topo();
		this.quantidade--;
		
		return topo;
	}

}
