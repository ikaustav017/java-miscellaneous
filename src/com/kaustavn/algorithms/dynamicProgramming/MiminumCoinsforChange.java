package com.kaustavn.algorithms.dynamicProgramming;
public class MiminumCoinsforChange {

	private static int MAX = 999999;

	public static void main(String[] args) {
		int[] coins = { 7, 2, 3, 6 };
		System.out.println("No of coins:" + MiminumCoinsforChange.getMinCoins(coins, 13));

	}

	public static long getMinCoins(int coins[], int money) {

		int[] minCoinCount = new int[money + 1];
		int[] coinTrack = new int[money + 1];

		for (int i = 0; i <= money; i++) {
			minCoinCount[i] = MAX;
			coinTrack[i] = -1;
		}
		minCoinCount[0] = 0;

		getMinCoinsByDPHelper(coins, money, minCoinCount, coinTrack);

		System.out.println("Coins are");
		int i = money;
		while (i > 0) {
			int coinIndex = coinTrack[i];
			System.out.println(coins[coinIndex]);
			i = i - coins[coinIndex];

		}
		return minCoinCount[money];

	}

	private static void getMinCoinsByDPHelper(int[] coins, int money, int[] minCoinCount, int[] coinTrack) {

		for (int i = 0; i < coins.length; i++) {
			int coinValue = coins[i];
			for (int j = 0; j <= money; j++) {
				if (j - coinValue >= 0) {
					if (minCoinCount[j] > (minCoinCount[j - coinValue] + 1)) {
						minCoinCount[j] = minCoinCount[j - coinValue] + 1;
						coinTrack[j] = i;
					}
				}
			}
		}

		for (int i = 0; i <= money; i++) {
			System.out.print("\t" + minCoinCount[i]);

		}
		System.out.println();
		for (int i = 0; i <= money; i++) {
			System.out.print("\t" + coinTrack[i]);
		}
		System.out.println();
	}

}
