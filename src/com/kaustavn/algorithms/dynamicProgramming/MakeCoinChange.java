package com.kaustavn.algorithms.dynamicProgramming;

public class MakeCoinChange {

	// 25cents,10cents,5cents,1cent
	// How many ways of making that change (say 27)
	public static int coinChangeRecursive(int sum) {
		if (sum == 1)
			return 1;
		return coinChangeRecursive(sum - 1) + getByDenom(sum, 5) + getByDenom(sum, 10) + getByDenom(sum, 25);
	}

	private static int getByDenom(int sum, int denom) {
		// TODO Auto-generated method stub
		if (sum % denom == 0)
			return 1;
		return 0;
	}

	public static int coinChangeMemo(int sum) {
		int[] mem = new int[sum + 1];
		return coinChnageMemoHelper(sum, mem);

	}

	private static int coinChnageMemoHelper(int sum, int[] mem) {
		if (sum <= 1)
			return 1;
		mem[sum] = coinChnageMemoHelper(sum - 1, mem) + getByDenom(sum, 5) + getByDenom(sum, 10) + getByDenom(sum, 25);
		return mem[sum];
	}

	public static void main(String[] args) {
		System.out.println(MakeCoinChange.coinChangeRecursive(1));
		System.out.println(MakeCoinChange.coinChangeRecursive(5));
		System.out.println(MakeCoinChange.coinChangeRecursive(10));
		System.out.println(MakeCoinChange.coinChangeRecursive(15));
		System.out.println(MakeCoinChange.coinChangeRecursive(25));

		System.out.println(MakeCoinChange.coinChangeMemo(1));
		System.out.println(MakeCoinChange.coinChangeMemo(5));
		System.out.println(MakeCoinChange.coinChangeMemo(10));
		System.out.println(MakeCoinChange.coinChangeMemo(15));
		System.out.println(MakeCoinChange.coinChangeMemo(25));

	}
}
