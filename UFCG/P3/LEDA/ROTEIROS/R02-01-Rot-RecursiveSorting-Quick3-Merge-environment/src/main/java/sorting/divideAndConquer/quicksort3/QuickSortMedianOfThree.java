package sorting.divideAndConquer.quicksort3;

import sorting.AbstractSorting;
import util.Util;

/**
 * A classe QuickSortMedianOfThree representa uma variação do QuickSort que
 * funciona de forma ligeiramente diferente. Relembre que quando o pivô
 * escolhido divide o array aproximadamente na metade, o QuickSort tem um
 * desempenho perto do ótimo. Para aproximar a entrada do caso ótimo, diversas
 * abordagens podem ser utilizadas. Uma delas é usar a mediana de 3 para achar o
 * pivô. Essa técnica consiste no seguinte:
 * 1. Comparar o elemento mais a esquerda, o central e o mais a direita do intervalo.
 * 2. Ordenar os elementos, tal que: A[left] < A[center] < A[right].
 * 3. Adotar o A[center] como pivô.
 * 4. Colocar o pivô na penúltima posição A[right-1].
 * 5. Aplicar o particionamento considerando o vetor menor, de A[left+1] até A[right-1].
 * 6. Aplicar o algoritmo na particao a esquerda e na particao a direita do pivô.
 */
public class QuickSortMedianOfThree<T extends Comparable<T>> extends
		AbstractSorting<T> {

	public void sort(T[] array, int leftIndex, int rightIndex) {
		if(array != null && leftIndex < rightIndex) {
			int center = (leftIndex + rightIndex) / 2;
			median(array, leftIndex, rightIndex, center);
			Util.swap(array, leftIndex, rightIndex - 1);
			int indexPivot = partition(array, leftIndex, rightIndex - 1);
			sort(array, leftIndex, indexPivot - 1);
			sort(array,indexPivot + 1, rightIndex);
		}
	}
	
	
	public void median(T[]array, int leftIndex, int rightIndex, int center) {
		if(array[leftIndex].compareTo(array[rightIndex]) > 0) {
			Util.swap(array, leftIndex, rightIndex);
		}
		if(array[center].compareTo(array[leftIndex]) < 0) {
			Util.swap(array, center, leftIndex);
		}
		if(array[center].compareTo(array[rightIndex]) > 0) {
			Util.swap(array, center, rightIndex);
		}
	}
	
	public int partition(T[] array, int left, int right) {
		T pivot = array[left];

		int i = left;

		for (int j = left + 1; j <= right; j++) {
			if (array[j].compareTo(pivot) <= 0) {
				i += 1;
				Util.swap(array, i, j);
			}
		}
		Util.swap(array, left, i);
		return i;
	}
}
