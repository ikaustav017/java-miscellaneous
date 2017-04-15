package com.kaustavn.algorithms.dynamicProgramming;

public class Fibonacci {

	// Space complexity O(n) for call stack + O(n) for the memory tablle = O(n)

	public static int getFibonacci(int n) {
		int[] memo = new int[n + 1];
		return getFibonacciHelper(n, memo);

	}

	private static int getFibonacciHelper(int n, int[] memo) {
		if (n == 0)
			return 1;
		if (n == 1)
			return 1;
		if (memo[n] == 0) {
			memo[n] = getFibonacciHelper(n - 1, memo) + getFibonacciHelper(n - 2, memo);
		} else {
			return memo[n];
		}

		return memo[n];

	}

	public static void main(String[] args) {
		System.out.println(Fibonacci.getFibonacci(6));

	}

}
