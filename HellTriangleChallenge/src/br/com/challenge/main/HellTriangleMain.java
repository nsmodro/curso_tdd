package br.com.challenge.main;

import br.com.challenge.hellTriangle.HellTriangle;

public class HellTriangleMain {

	public static void main(String[] args) {
		
		Integer[][] triangulo1 = {{6},{3,5},{9,7,1},{4,6,8,4}};
		Integer[][] triangulo2 = new Integer[15][];
		
		for (int i = 0; i < triangulo2.length; i++) {
			triangulo2[i] = new Integer[i+1];
			for (int j = 0; j < i+1; j++) {
				triangulo2[i][j] = (int) (Math.random() * 10);
			}
		}

		HellTriangle ht1 = new HellTriangle();
		HellTriangle ht2 = new HellTriangle();
		ht1.inicializaTriangulo(triangulo1);
		ht2.inicializaTriangulo(triangulo2);

		System.out.println("\nA soma máxima para os elementos do triangulo abaixo é: " + ht1.getSoma());

		for (Integer[] linhaTriangulo : ht1.getTriangulo()) {
			System.out.println("");
			for (int i = 0; i < linhaTriangulo.length; i++) {
				System.out.print(linhaTriangulo[i].toString());
			}
		}

		System.out.println("\n\nA soma máxima para os elementos do triangulo abaixo é: " + ht2.getSoma());

		for (Integer[] linhaTriangulo : ht2.getTriangulo()) {
			System.out.println("");
			for (int i = 0; i < linhaTriangulo.length; i++) {
				System.out.print(linhaTriangulo[i].toString());
			}
		}
		
	}

}
