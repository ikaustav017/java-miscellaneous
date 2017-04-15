package com.kaustavn.algorithms;

public class StaircaseSteps {
	/*
	 * YOu can jump one, two or three steps at a time how many paths are there
	 * if the staircase length is 100 steps
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int countPathsRecursive(int steps) {

		// O(3^n) this is super slow
		if (steps < 0)
			return 0;
		else if (steps == 0)
			return 1;
		return countPathsRecursive(steps - 1) + countPathsRecursive(steps - 2) + countPathsRecursive(steps - 3);
	}

	public static int countPathMemo(int steps) {

		// this is linear time but takes O n space
		return countPathsMemorization(steps, new int[steps + 1]);
	}

	public static int countPathsMemorization(int steps, int[] memo) {

		if (steps < 0)
			return 0;
		else if (steps == 0)
			return 1;

		if (memo[steps] == 0) {
			memo[steps] = countPathsMemorization(steps - 1, memo) + countPathsMemorization(steps - 2, memo)
					+ countPathsMemorization(steps - 3, memo);
		}
		return memo[steps];
	}

	public static int countPathsDP(int steps) {

		// O(n) time and O(n) space
		if (steps < 0)
			return 0;
		else if (steps <= 1)
			return 1;

		int[] paths = new int[steps + 1];
		paths[0] = 1;
		paths[1] = 1;
		paths[2] = 2;

		for (int i = 3; i <= steps; i++) {
			paths[i] = paths[i - 1] + paths[i - 2] + paths[i - 3];
		}
		return paths[steps];
	}

	public static int countPathsDPIterative(int steps) {

		// Notice in above method, we only need to store the last 3 values of
		// paths
		if (steps < 0)
			return 0;
		else if (steps <= 1)
			return 1;

		int[] paths = { 1, 1, 2 };

		for (int i = 3; i <= steps; i++) {
			int count = paths[2] + paths[1] + paths[0];
			paths[0] = paths[1];
			paths[1] = paths[2];
			paths[3] = count;
		}
		return paths[2];
	}

}
