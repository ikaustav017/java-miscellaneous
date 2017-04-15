package com.kaustavn.algorithms;

import java.util.Arrays;

public class TwoSum {

	public static int[] twoSum(int arr[], int sum) {

		int[] sortedArr = arr.clone();
		Arrays.sort(sortedArr);
		int i = 0;
		while (i < sortedArr.length - 1) {
			if (sortedArr[i] < sum) {
				int index = binarySearchHelper(sortedArr, sum - sortedArr[i], i + 1, (sortedArr.length) - 1);
				if (index != -1) {
					// System.out.println(sortedArr[i]);
					// System.out.println(sum - sortedArr[i]);
					int[] indeces = getIndexesFromValue(arr, sortedArr[i], sum - sortedArr[i]);
					return indeces;
				}
			}
			i++;
		}

		return null;

	}

	private static int binarySearchHelper(int[] sortedArr, int value, int start, int end) {
		if (start > end)
			return -1;
		int mid = (start + end) / 2;
		if (sortedArr[mid] == value)
			return mid;
		if (sortedArr[mid] > value)
			return binarySearchHelper(sortedArr, value, start, mid - 1);
		if (sortedArr[mid] < value)
			return binarySearchHelper(sortedArr, value, mid + 1, end);
		return -1;
	}

	private static int[] getIndexesFromValue(int[] arr, int item1, int item2) {

		int index1 = getIndex(arr, item1, -1);
		int index2 = getIndex(arr, item2, index1);
		int indeces[] = { Math.min(index1, index2), Math.max(index1, index2) };
		return indeces;
	}

	private static int getIndex(int[] arr, int item2, int excludeThis) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == item2 && i != excludeThis) {
				return i;
			}
		}
		// TODO Auto-generated method stub
		return 0;
	}

	public static void main(String[] args) {

		int[] arr = { 1, 5, 4, 5, 7 };
		int[] index = TwoSum.twoSum(arr, 10);
		System.out.println(index[0]);
		System.out.println(index[1]);
	}
}
