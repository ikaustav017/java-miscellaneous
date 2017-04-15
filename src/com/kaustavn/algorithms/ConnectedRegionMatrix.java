package com.kaustavn.algorithms;

public class ConnectedRegionMatrix {

	/*
	 * Given a matrix with 0s and 1s, find the biggest connected region of 1s
	 * connected can be vertically,horizontally and diagonally
	 * 
	 * This is kind of a a dfs.. find the first 1 set it to 0 (so we do not
	 * vrevisit it again, also it does a isVisited check recursively call its
	 * neighbours to find the area
	 */

	public static int getRegionSize(int matrix[][], int row, int col) {

		if (row < 0 || col < 0 || row >= matrix.length || col >= matrix[row].length)
			return 0;
		if (matrix[row][col] == 0)
			return 0;
		// not searching same region multiple times and ll also do a isVisited
		// check for the dfs
		matrix[row][col] = 0;

		int size = 1;
		for (int r = row - 1; r <= row + 1; r++) {
			for (int c = col - 1; c <= col + 1; c++) {
				if (r != row || c != col)
					size += getRegionSize(matrix, r, c);
			}
		}
		return size;
	}

	public static int getBiigestRegion(int[][] matrix) {

		// we will update the matrix so as to avoid going through same 1's over
		// and over again
		int maxregion = 0;
		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[row].length; col++) {
				if (matrix[row][col] == 1) {
					int size = getRegionSize(matrix, row, col);
					maxregion = Math.max(maxregion, size);
				}
			}
		}

		return 0;
	}

}
