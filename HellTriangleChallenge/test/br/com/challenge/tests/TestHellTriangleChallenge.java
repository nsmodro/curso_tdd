package br.com.challenge.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.com.challenge.exception.TrianguloInvalidoException;
import br.com.challenge.hellTriangle.HellTriangle;


/**
 * @author Natacha Modro
 * 
 * 
 * Hell Triangle - Challenge
 * 
 * Given a triangle of numbers, find the maximum total from top to bottom
 * Example:
 *    6
 *   3 5
 *  9 7 1
 * 4 6 8 4 
 * In this triangle the maximum total is 6 + 5 + 7 + 8 = 26
 * 
 * 
 * An element can only be summed with one of the two nearest elements in the next row
 * So the element 3 in row 2 can be summed with 9 and 7, but not with 1
 * Choose the programming language you want... let us know about why is that your choice
 * Besides the solution itself, write an automated test for your code (using a known framework
 * or just another function/method)
 * 
 * Your code will receive an (multidimensional) array as input.
 * 
 * The triangle from above would be:
 * example = [[6],[3,5],[9,7,1],[4,6,8,4]]
 * 
 * We are interested in your solution considering:
 * 1. Correctness;
 * 2. Readability;
 * 3. The automated test;
 * 4. Execution time;
 */
public class TestHellTriangleChallenge {
	
	HellTriangle ht;
	
	@Before
	public void inicializaHellTriangle(){
		ht  = new HellTriangle();
	}

	@Test(expected=NullPointerException.class)
	public void trianguloVazio() {
		ht.inicializaTriangulo(null);
	}
	
	@Test
	public void inicializaTrianguloValido() {
		Integer[][] dadosVetor = {{6},{3,5},{9,7,1},{4,6,8,4}};
		ht.inicializaTriangulo(dadosVetor);
	}
	
	@Test(expected=TrianguloInvalidoException.class)
	public void inicializaTrianguloInvalidoSituacao1() {
		Integer[][] dadosVetor = {{6},{3,5,7},{9,7,1},{4,6,8,4}};
		ht.inicializaTriangulo(dadosVetor);
	}
	
	@Test(expected=TrianguloInvalidoException.class)
	public void inicializaTrianguloInvalidoSituacao2() {
		Integer[][] dadosVetor = {{6,2},{3,2},{9,7,1},{4,6,8,4}};
		ht.inicializaTriangulo(dadosVetor);
	}
	
	@Test
	public void maximoTotalTrianguloSituacao1() {
		Integer[][] dadosVetor = {{6},{3,5},{9,7,1},{4,6,8,4}};
		ht.inicializaTriangulo(dadosVetor);
		assertEquals(new Integer(26), ht.getSoma());
	}
	
	@Test
	public void maximoTotalTrianguloSituacao2() {
		Integer[][] dadosVetor = {{6}};
		ht.inicializaTriangulo(dadosVetor);
		assertEquals(new Integer(6), ht.getSoma());
	}
	
	@Test
	public void maximoTotalTrianguloSituacao3() {
		Integer[][] dadosVetor = {{2},{7,3},{4,2,5},{8,1,9,6},{7,9,8,9,6}};
		ht.inicializaTriangulo(dadosVetor);
		assertEquals(new Integer(30), ht.getSoma());
	}
	
	@Test
	public void maximoTotalTrianguloNumerosIguaisSituacao1() {
		Integer[][] dadosVetor = {{3},{7,7},{9,2,4},{1,4,6,5}};
		ht.inicializaTriangulo(dadosVetor);
		assertEquals(new Integer(23), ht.getSoma());
	}
	
	@Test
	public void maximoTotalTrianguloNumerosIguaisSituacao2() {
		Integer[][] dadosVetor = {{8},{1,1},{9,8,7},{7,7,2,9},{1,1,1,1,1}};
		ht.inicializaTriangulo(dadosVetor);
		assertEquals(new Integer(26), ht.getSoma());
	}

}
