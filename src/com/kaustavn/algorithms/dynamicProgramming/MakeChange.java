package com.kaustavn.algorithms.dynamicProgramming;

import java.util.HashMap;

public class MakeChange {

	public static long coinChangeRecursive(int[] coins, int money) {
		return changeRecursiveHelper(coins, money, 0);
	}

	private static long changeRecursiveHelper(int[] coins, int money, int index) {

		if (money == 0)
			return 1;
		if (index >= coins.length)
			return 0;

		int amtWithCurrentCoin = 0;
		int ways = 0;
		while (amtWithCurrentCoin <= money) {
			int remainingAmount = money - amtWithCurrentCoin;
			ways += changeRecursiveHelper(coins, remainingAmount, index + 1);
			amtWithCurrentCoin += coins[index];
		}

		return ways;
	}

	public static long changeCoinByDP(int coins[], int money) {
		return changeCoinByDPHelper(coins, money, 0, new HashMap<String, Long>());

	}

	private static long changeCoinByDPHelper(int[] coins, int money, int index, HashMap<String, Long> hashMap) {
		if (money == 0)
			return 1;
		if (index >= coins.length)
			return 0;
		int amtWithCurrentCoin = 0;
		long ways = 0;

		// include dash because otherwise 25+1 becomes equal to 2+51
		String key = String.valueOf(money) + '-' + index;
		System.out.println(key);
		if (hashMap.containsKey(key)) {
			return hashMap.get(key);
		}

		while (amtWithCurrentCoin <= money) {
			int remainingAmount = money - amtWithCurrentCoin;
			ways += changeCoinByDPHelper(coins, remainingAmount, index + 1, hashMap);
			amtWithCurrentCoin += coins[index];

		}
		hashMap.put(key, ways);
		return ways;
	}

	public static void main(String[] args) {
		int[] coins = { 1, 5, 10, 25 };
		System.out.println(MakeChange.coinChangeRecursive(coins, 1));
		System.out.println(MakeChange.coinChangeRecursive(coins, 5));
		System.out.println(MakeChange.coinChangeRecursive(coins, 10));
		System.out.println(MakeChange.coinChangeRecursive(coins, 15));
		System.out.println(MakeChange.coinChangeRecursive(coins, 25));

		System.out.println(MakeChange.changeCoinByDP(coins, 1));
		System.out.println(MakeChange.changeCoinByDP(coins, 5));
		System.out.println(MakeChange.changeCoinByDP(coins, 10));
		System.out.println(MakeChange.changeCoinByDP(coins, 15));
		System.out.println(MakeChange.changeCoinByDP(coins, 25));

	}

}
