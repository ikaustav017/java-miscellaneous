package com.kaustavn.strings;

public class ReverseWords {

	// input: A street car named desire.
	// output: desire. named car street A

	public static String reverse(String src) throws Exception {

		if (src.isEmpty())
			throw new Exception("String is empty");

		int length = src.length() - 1;
		int readStart = length, readStop = length, writeStart = 0, wordEnd = 0;

		char dest[] = new char[src.length()];

		// start from the end of the string and move backwards
		while (readStart >= 0) {

			// iterate till encountering space or index = -1
			while (readStart >= 0 && src.charAt(readStart) != ' ') {
				readStart--;
			}
			// mark the beginning of the token
			wordEnd = readStart;

			while (readStart < readStop) {
				// write the word till you hit the end marked by readStop
				dest[writeStart++] = src.charAt(++readStart);
			}

			// if index is not zero implies we encountered space..So add it to
			// the destination
			if (wordEnd > 0) {
				dest[writeStart++] = ' ';
			}

			// move readstart & readstop to the index left of space
			readStart = wordEnd - 1;
			readStop = wordEnd - 1;
		}
		return String.valueOf(dest);
	}

	public static void main(String[] args) {

		try {

			System.out.println(reverse(" "));
			System.out.println(reverse("desire"));
			System.out.println(reverse("A street"));
			System.out.println(reverse("A street car named desire."));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
