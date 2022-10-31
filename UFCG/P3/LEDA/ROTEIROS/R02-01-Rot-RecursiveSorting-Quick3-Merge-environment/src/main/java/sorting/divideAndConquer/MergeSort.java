package sorting.divideAndConquer;

import sorting.AbstractSorting;

/**
 * Merge sort is based on the divide-and-conquer paradigm. The algorithm
 * consists of recursively dividing the unsorted list in the middle, sorting
 * each sublist, and then merging them into one single sorted list. Notice that
 * if the list has length == 1, it is already sorted.
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {
	public void merge(T[]array, int left, int middle, int right) {
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
	
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
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
}
