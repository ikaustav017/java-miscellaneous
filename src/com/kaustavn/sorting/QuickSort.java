package com.kaustavn.sorting;

public class QuickSort {

	private static void quicksort(int arr[], int leftStart, int rightEnd) {

		if (leftStart >= rightEnd)
			return;
		int pivotIndex = (leftStart + rightEnd) / 2;

		int pivot = arr[pivotIndex];

		int index = partition(arr, leftStart, rightEnd, pivot);
		quicksort(arr, leftStart, index - 1);
		quicksort(arr, index, rightEnd);

	}

	private static int partition(int[] arr, int leftStart, int rightEnd, int pivot) {

		while (leftStart <= rightEnd) {

			// find element bigger than pivot on left side
			while (arr[leftStart] < pivot) {
				leftStart++;
			}

			// find element smaller than pivot in right side
			while (arr[rightEnd] > pivot) {
				rightEnd--;
			}

			// swap
			if (leftStart <= rightEnd) {

				swap(arr, leftStart, rightEnd);
				leftStart++;
				rightEnd--;
			}

		}

		return leftStart;

	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;

	}

	public static void quicksort(int arr[]) {
		quicksort(arr, 0, arr.length - 1);
	}

	public static void main(String[] args) {
		int[] arr = { 1, 8, 5, 4, 7, 2, 5 };
		QuickSort.quicksort(arr);

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
