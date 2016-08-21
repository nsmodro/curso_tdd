package br.com.challenge.hellTriangle;

import br.com.challenge.exception.TrianguloInvalidoException;

public class HellTriangle {
	
	private Integer[][] triangulo;
	
	public void inicializaTriangulo(Integer[][] triangulo) {
		if (triangulo == null)
			throw new NullPointerException();

		validaTriangulo(triangulo);
		
		setTriangulo(triangulo);
	}
	

	public Integer getSoma() {
		Integer soma = 0;		
		int indiceNo = 0;
		int indiceLinha = 0;
		
		for (Integer[] linhaTriangulo : triangulo) {
			if (linhaTriangulo.length == 1) {
				soma += linhaTriangulo[indiceNo];
				
			} else {
				
				if ((linhaTriangulo[indiceNo] == linhaTriangulo[indiceNo + 1]) && (indiceLinha + 1 < triangulo.length)) {
					int indiceProximaLinha = indiceLinha + 1;
					
					if ((triangulo[indiceProximaLinha][indiceNo] > triangulo[indiceProximaLinha][indiceNo+1])
							&& (triangulo[indiceProximaLinha][indiceNo] > triangulo[indiceProximaLinha][indiceNo+2])) {
						soma += linhaTriangulo[indiceNo];
						
					} else {
						soma += linhaTriangulo[indiceNo+1];
						indiceNo++;
					}
				} else {
					if (linhaTriangulo[indiceNo] > linhaTriangulo[indiceNo + 1]) {
						soma += linhaTriangulo[indiceNo];
					} else {
						soma += linhaTriangulo[indiceNo+1];
						indiceNo++;
					}
				}
			}
			indiceLinha++;
		}
		return soma;
	}
	
	
	private void validaTriangulo(Integer[][] triangulo) {
		int qtdeElementoPorLinha = -1;
		
		for (Integer[] trianguloLinha : triangulo) {
			if (qtdeElementoPorLinha == -1 && trianguloLinha.length != 1) 
				throw new TrianguloInvalidoException("Deve ter apenas um elemento na primeira linha.");
			
			if (qtdeElementoPorLinha == -1)
				qtdeElementoPorLinha = 0;
			
			if (trianguloLinha.length != qtdeElementoPorLinha + 1) 
				throw new TrianguloInvalidoException("A estrutura do triangulo não está sendo respeitada.");
			
			qtdeElementoPorLinha++;
		}
	}
	
	
	public Integer[][] getTriangulo() {
		return triangulo;
	}

	public void setTriangulo(Integer[][] triangulo) {
		this.triangulo = triangulo;
	}
}
