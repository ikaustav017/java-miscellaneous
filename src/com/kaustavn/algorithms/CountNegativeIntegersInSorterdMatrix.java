/**
 * 
 */
package com.kaustavn.algorithms;

/**
 * @author kaustav
 *
 *         You are given a row and column sorted matrix. you need to count the
 *         num of negative integers
 */

public class CountNegativeIntegersInSorterdMatrix {

	private int[][] matrix;
	private int row;
	private int column;

	public CountNegativeIntegersInSorterdMatrix(int row, int col) {
		if (row > 0 && col > 0) {
			this.row = row;
			this.column = col;
			matrix = new int[row][col];
		}

		else
			System.out.println("Invalid parameters. Row or col cannot be -ve");

	}

	private void setMatrix(int i, int j, int value) {
		if (i < row && j < column)
			matrix[i][j] = value;
	}

	private void displayMatrix() {

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				System.out.print("\t" + matrix[i][j]);
			}

			System.out.print("\n");

		}
	}

	private int countNegativeInt() {

		int count = 0, i = 0;
		int j = column - 1;
		while (j >= 0 && i < row) {
			if (matrix[i][j] < 0) {
				count += j + 1;
				i += 1;
			} else {
				j--;
			}
		}
		return count;
	}

	public static void main(String[] args) {

		CountNegativeIntegersInSorterdMatrix object = new CountNegativeIntegersInSorterdMatrix(3, 4);
		object.setMatrix(0, 0, -3);
		object.setMatrix(0, 1, -2);
		object.setMatrix(0, 2, -1);
		object.setMatrix(0, 3, 1);
		object.setMatrix(1, 0, -2);
		object.setMatrix(1, 1, 2);
		object.setMatrix(1, 2, 3);
		object.setMatrix(1, 3, 4);
		object.setMatrix(2, 0, 4);
		object.setMatrix(2, 1, 5);
		object.setMatrix(2, 2, 7);
		object.setMatrix(2, 3, 8);
		object.displayMatrix();
		System.out.println(object.countNegativeInt());

	}
}
