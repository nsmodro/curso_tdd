import java.util.ArrayList;
import java.util.List;

public class CarrinhoCompras {
	
	private List<Produto> itens = new ArrayList<>();
	private List<ObservadorCarrinho> observadores = new ArrayList<>();
	
	public void adicionaProduto(Produto p) {
		itens.add(p);
		for (ObservadorCarrinho observador : observadores) {
			try {

				observador.produtoAdicionado(p.getNome(), p.getValor());

			} catch (Exception e) {
			}
		}
		
//		if (observador != null) {
//			observador.produtoAdicionado(p.getNome(), p.getValor());
//		}
	}
	
	public int total() {
		int total = 0;
		for (Produto produto : itens) {
			total += produto.getValor();
		}
		return total;
	}

	public void adicionaObservador(ObservadorCarrinho observador) {
		observadores.add(observador);
		
	}
	
}
