package sorting.divideAndConquer.hybridMergesort;

import sorting.AbstractSorting;
import util.Util;

/**
 * A classe HybridMergeSort representa a implementação de uma variação do
 * MergeSort que pode fazer uso do InsertionSort (um algoritmo híbrido) da
 * seguinte forma: o MergeSort é aplicado a entradas maiores a um determinado
 * limite. Caso a entrada tenha tamanho menor ou igual ao limite o algoritmo usa
 * o InsertionSort.
 * 
 * A implementação híbrida deve considerar os seguintes detalhes:
 * - Ter contadores das quantidades de MergeSorts e InsertionSorts aplicados, de forma
 *   que essa informação possa ser capturada pelo teste.
 * - A cada chamado do método de sort(T[] array) esses contadores são resetados. E a cada chamada
 *   interna de um merge ou insertion, os contadores MERGESORT_APPLICATIONS e
 *   INSERTIONSORT_APPLICATIONS são incrementados.
 * - O InsertionSort utilizado no algoritmo híbrido deve ser in-place.
 */
public class HybridMergeSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	/**
	 * For inputs with size less or equal to this value, the insertionsort
	 * algorithm will be used instead of the mergesort.
	 */
	public static final int SIZE_LIMIT = 4;

	protected static int MERGESORT_APPLICATIONS = 0;
	protected static int INSERTIONSORT_APPLICATIONS = 0;

	public void sort(T[] array, int leftIndex, int rightIndex) {
		if(array != null) {
			if(array.length > SIZE_LIMIT) {
				mergeSort(array, leftIndex, rightIndex);
			}
		}else {
			insertionSort(array, leftIndex, rightIndex);
		}
	}
	
	public void merge(T[]array, int left, int middle, int right) {
		MERGESORT_APPLICATIONS ++;
		T[] arrayAuxiliar = (T[]) new Comparable[array.length];
		if(array != null) {
		for (int i = left; i <= right; i++) {
			arrayAuxiliar[i] = array[i];
		}
		int i = left;
		int j = middle + 1;
		int k = left;
		
		while(i <= middle && j<= right) {
			if(arrayAuxiliar[i].compareTo(arrayAuxiliar[j]) <= 0) {
				array[k++] = arrayAuxiliar[i++];
			}else {
				array[k++] = arrayAuxiliar[j++];
			}
		}
		while(i <= middle) {
			array[k++] = arrayAuxiliar[i++];
		}
		while(j <= right) {
			array[k++] = arrayAuxiliar[j++];
		}
	}
	}
	
	public void mergeSort(T[] array, int leftIndex, int rightIndex) {
		if(array != null) {
		if(leftIndex >= rightIndex) {
			return;
		}else {
			int middle = (leftIndex + rightIndex) / 2;
			sort(array, leftIndex, middle);
			sort(array, middle + 1, rightIndex);
			merge(array, leftIndex, middle, rightIndex);
		}
	}
  }
	public void insertionSort(T[] array, int leftIndex, int rightIndex) {
		INSERTIONSORT_APPLICATIONS ++;
		if (leftIndex < rightIndex && array != null) {
			for (int i = leftIndex + 1; i <= rightIndex; i++) {
				int j = i;

				while (j > leftIndex && array[j].compareTo(array[j - 1]) < 0) {
					Util.swap(array, j, j - 1);
					j -= 1;
				}
			}
		}
	}
}
