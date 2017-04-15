package com.kaustavn.sorting;

public class MergeSort {

	public static void mergesort(int[] arr, int[] temp, int leftStart, int rightEnd) {
		if (leftStart >= rightEnd)
			return;

		int mid = (leftStart + rightEnd) / 2;

		mergesort(arr, temp, leftStart, mid);
		mergesort(arr, temp, mid + 1, rightEnd);
		mergeHalves(arr, temp, leftStart, rightEnd);

	}

	private static void mergeHalves(int[] arr, int[] temp, int leftStart, int rightEnd) {

		int leftEnd = (leftStart + rightEnd) / 2;
		int rightStart = leftEnd + 1;
		int size = rightEnd - leftStart + 1;

		int left = leftStart;
		int right = rightStart;
		int index = leftStart;

		while (left <= leftEnd && right <= rightEnd) {
			if (arr[left] <= arr[right]) {
				temp[index++] = arr[left++];
			} else {
				temp[index++] = arr[right++];
			}
		}

		while (left <= leftEnd)
			temp[index++] = arr[left++];

		// System.arraycopy(arr, left, temp, index, leftEnd-left+1);

		while (right <= rightEnd)
			temp[index++] = arr[right++];

		// System.arraycopy(arr, right, temp, index, rightEnd-right+1);

		System.arraycopy(temp, leftStart, arr, leftStart, size);

	}

	public static void main(String[] args) {
		int[] arr = { 1, 8, 5, 4, 7, 2, 5 };
		MergeSort.merge(arr);

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	private static void merge(int[] arr) {
		mergesort(arr, new int[arr.length], 0, arr.length - 1);

	}
}
