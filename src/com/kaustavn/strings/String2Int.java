package com.kaustavn.strings;

public class String2Int {

	/*
	 * 371 3*1 =3 3*10+7 =37 37*10+1 =371
	 */

	public static int StringtoInt(String s) throws Exception {

		if (s == null || s.isEmpty() || "+".equalsIgnoreCase(s) || "-".equalsIgnoreCase(s)) {
			return 0;
		}
		if (s.contains("+") && s.contains("-")) {
			return 0;
		}
		if (s.contains("."))
			return 0;

		int length = s.length();
		int result = 0, i = 0;
		boolean negativeFlag = false;

		while (i < length) {
			if (s.charAt(i) == ' ') {
				i++;
				continue;
			}

			break;
		}

		if (s.charAt(i) == '-') {
			negativeFlag = true;
			i++;
		}

		if (s.charAt(i) == '+') {
			negativeFlag = false;
			i++;
		}

		while (i < length) {

			int value = s.charAt(i) - '0';

			if (value > 9 || value < 0)
				break;
			result = result * 10 + value;
			i++;
		}
		if (negativeFlag) {
			result = result * -1;
		}

		return result;
	}

	public static void main(String args[]) {

		try {

			System.out.println(String2Int.StringtoInt("450"));
			System.out.println(String2Int.StringtoInt("-189"));
			System.out.println(String2Int.StringtoInt("0"));
			System.out.println(String2Int.StringtoInt("-1"));
			System.out.println(String2Int.StringtoInt("1"));
			System.out.println(String2Int.StringtoInt(""));
			System.out.println(String2Int.StringtoInt("+10"));

			System.out.println(String2Int.StringtoInt("     -10"));
			System.out.println(String2Int.StringtoInt("     -0010as57"));
			System.out.println(String2Int.StringtoInt("2147483648"));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

}
