package com.kaustavn.strings;

public class CheckIfAnagrams {

	public static boolean areAnagrams(String s1, String s2) {

		if (s1.length() != s2.length())
			return false;
		int[] asci = new int[52];

		for (int i = 0; i < s1.length(); i++) {
			int index = getIndex(s1.charAt(i));
			asci[index]++;
		}

		for (int i = 0; i < s2.length(); i++) {
			int index = getIndex(s2.charAt(i));
			if (asci[index] <= 0)
				return false;
			asci[index]--;
		}

		for (int i = 0; i < 52; i++) {
			if (asci[i] != 0)
				return false;
		}

		return true;
	}

	public static int getIndex(char c) {
		int lowerCase = c - 'a';
		int upperCase = c - 'A';

		if (lowerCase < 26 && lowerCase >= 0)
			return lowerCase;

		if (upperCase < 26 && upperCase >= 0)
			return (upperCase + 26);

		return -1;

	}

	public static void main(String[] args) {

		System.out.println(CheckIfAnagrams.areAnagrams("abcABC", "ABCabc"));

	}

}
