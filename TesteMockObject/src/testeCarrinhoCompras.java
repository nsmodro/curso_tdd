import static org.junit.Assert.*;

import org.junit.Test;

public class testeCarrinhoCompras {

	@Test
	public void totalCarrinho() {
		CarrinhoCompras c = new CarrinhoCompras();
		c.adicionaProduto(new Produto("tenis", 100));
		c.adicionaProduto(new Produto("camiseta", 50));
		c.adicionaProduto(new Produto("bermuda", 70));
		assertEquals(220, c.total());
	}
	
	@Test
	public void escutaAdicaoDeProduto() {
		CarrinhoCompras c = new CarrinhoCompras();
		MockObservadorCarrinho mock = new MockObservadorCarrinho();
		c.adicionaObservador(mock);
		c.adicionaProduto(new Produto("tenis", 100));
		mock.verificaRecebimentoProduto("tenis", 100);
	}
	
	@Test
	public void escutaDoisObservadores() {
		CarrinhoCompras c = new CarrinhoCompras();
		MockObservadorCarrinho mock1 = new MockObservadorCarrinho();
		MockObservadorCarrinho mock2 = new MockObservadorCarrinho();
		c.adicionaObservador(mock1);
		c.adicionaObservador(mock2);
		c.adicionaProduto(new Produto("tenis", 100));
		mock1.verificaRecebimentoProduto("tenis", 100);
		mock2.verificaRecebimentoProduto("tenis", 100);
	}
	
	@Test
	public void continuaNotificandoComErroObservador() {
		CarrinhoCompras c = new CarrinhoCompras();
		MockObservadorCarrinho mock1 = new MockObservadorCarrinho();
		MockObservadorCarrinho mock2 = new MockObservadorCarrinho();
		mock2.queroQueDeErro();
		MockObservadorCarrinho mock3 = new MockObservadorCarrinho();
		c.adicionaObservador(mock1);
		c.adicionaObservador(mock2);
		c.adicionaObservador(mock3);
		c.adicionaProduto(new Produto("tenis", 100));
		mock1.verificaRecebimentoProduto("tenis", 100);
		mock3.verificaRecebimentoProduto("tenis", 100);
	}

}
