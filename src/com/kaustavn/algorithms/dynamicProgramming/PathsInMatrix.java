package com.kaustavn.algorithms.dynamicProgramming;

/*
 * you are given a grid with some intersectionsblocked
 * you are only allowed to left  right or move down
 * HOw many ways from top left corner top bottom right corner
 */
public class PathsInMatrix {

	// run time O(2^n)
	public static long countPathsByRecursion(boolean grid[][]) {
		return (countPathsByRecursionHelper(grid, 0, 0));

	}

	public static long countPathsByRecursionHelper(boolean grid[][], int row, int col) {

		if (row == grid.length && col == grid.length) {
			return 1;
		}
		if (!validSquare(grid, row, col))
			return 0;

		return countPathsByRecursionHelper(grid, row + 1, col) + countPathsByRecursionHelper(grid, row, col + 1);
	}

	private static boolean validSquare(boolean[][] grid, int row, int col) {
		if (grid.length >= row || grid.length >= col) {
			return false;
		}
		if (grid[row][col]) {
			// blocked intersection
			return false;
		}
		return true;
	}

	// run time O(N^2)
	public static int countPathsByMemoization(boolean grid[][]) {
		return (countPathsByMemoizationHelper(grid, 0, 0, new int[grid.length][grid.length]));

	}

	public static int countPathsByMemoizationHelper(boolean grid[][], int row, int col, int path[][]) {

		if (row == grid.length && col == grid.length) {
			return 1;
		}
		if (!validSquare(grid, row, col))
			return 0;
		if (path[row][col] == 0) {
			path[row][col] = countPathsByMemoizationHelper(grid, row + 1, col, path)
					+ countPathsByMemoizationHelper(grid, row, col + 1, path);

		}

		return path[row][col];

	}

}
