package com.kaustavn.strings;

public class RemoveSpecifiedCharacters {

	public static String removeChars(String str, String remove) throws Exception {

		if (remove.isEmpty() || str.isEmpty()) {
			throw new Exception("Strings cant be empty");
		}

		boolean[] flags = new boolean[128];
		// set flags for ASCI
		for (int i = 0; i < remove.length(); i++) {
			flags[remove.charAt(i)] = true;
		}

		StringBuffer result = new StringBuffer();
		for (int i = 0; i < str.length(); i++) {
			if (!flags[str.charAt(i)]) {
				result.append(str.charAt(i));
			}
		}

		return result.toString();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			System.out.println(removeChars("I cant code", "t"));
			System.out.println(removeChars("I am not guilty", "not"));
			System.out.println(removeChars("01234,56789- -98765.4321", "9-8."));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
