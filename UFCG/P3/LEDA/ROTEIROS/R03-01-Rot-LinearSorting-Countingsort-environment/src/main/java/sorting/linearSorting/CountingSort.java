package sorting.linearSorting;

import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Stream;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala.
 *
 * Procure evitar desperdício de memória: AO INVÉS de alocar o array de contadores
 * com um tamanho arbitrariamente grande (por exemplo, com o maior valor de entrada possível),
 * aloque este array com o tamanho sendo o máximo inteiro presente no array a ser ordenado.
 *
 * Seu algoritmo deve assumir que o array de entrada nao possui numeros negativos,
 * ou seja, possui apenas numeros inteiros positivos e o zero.
 *
 */

/*
 * private boolean verificação(Integer[] array, int leftIndex, int rightIndex){
 * if(array != null && array.length > 0 && leftIndex < rightIndex && leftIndex >= 0 && rigthIndex < array.length){
 * return true;
 * }
 * return false;
 * }
 */
public class CountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		Integer[] C = new Integer[6];
		if(verificacao(array, leftIndex, rightIndex)) {
			System.out.println("Ola");
			
			
		}
		
	}
	
	 public boolean verificacao(Integer[] array, int leftIndex, int rigthIndex) {
		if(array != null && array.length > 0 && leftIndex < rigthIndex && leftIndex >= 0 && rigthIndex < array.length) {
			return true;
		}
		return false;
	}
	 
	 
	

}
