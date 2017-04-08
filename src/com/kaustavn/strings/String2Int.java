package com.kaustavn.strings;

public class String2Int {

	/*
	 * 371 3*1 =3 3*10+7 =37 37*10+1 =371
	 */

	public static int StringtoInt(String s) throws Exception {

		if (s.isEmpty()) {
			throw new Exception("String cannot be null or empty");
		}
		int length = s.length();
		int result = 0, i = 0;
		boolean negativeFlag = false;

		if (s.charAt(i) == '-' && i == 0) {
			negativeFlag = true;
			i = 1;
		}

		while (i < length) {

			int value = s.charAt(i) - '0';
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
			System.out.println(String2Int.StringtoInt(null));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

}
