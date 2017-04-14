package com.kaustavn.algorithms;

public class RunLengthEncoding {

	public static String Encoder(String input) {

		if (input == null)
			return null;
		StringBuilder output = new StringBuilder();
		int j = 0, count = 0;
		for (int i = 0; i < input.length(); i++) {

			if (output.length() == 0) {
				output.append(input.charAt(i));
			}
			if (output.charAt(j) == input.charAt(i)) {
				count++;
			} else {
				output.append(count);
				output.append(input.charAt(i));
				j += 2;
				count = 1;
			}

		}
		if (count != 0)
			output.append(count);

		return output.toString();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(RunLengthEncoding.Encoder(null));
		System.out.println(RunLengthEncoding.Encoder(""));
		System.out.println(RunLengthEncoding.Encoder("q"));
		System.out.println(RunLengthEncoding.Encoder("qqq"));
		System.out.println(RunLengthEncoding.Encoder("qwerty"));
		System.out.println(RunLengthEncoding.Encoder("qqqwwwwwrrrrrrtttttt"));

	}

}
