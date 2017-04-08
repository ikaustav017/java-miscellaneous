package com.kaustavn.recursion;

public class Combination {

	private String src;
	private StringBuilder out;

	public Combination(String src) {
		this.src = src;
		out = new StringBuilder();
	}

	public void combine() {
		if (src == null) {
			return;
		}
		combine(0);
	}

	public void combine(int start) {

		// for a given position, sequentially select all letters from the input
		// string position to the last letter in the input.
		// For each letter you select, append it to the output, print the output
		// and then generate
		// all other combinations beginning with this sequence by recursively
		// calling
		// the generating function with the input start
		// position set to the next letter

		for (int i = start; i < src.length(); i++) {
			out.append(src.charAt(i));
			System.out.println(out);
			if (i < src.length()) {
				combine(i + 1);
			}
			out.setLength(out.length() - 1);
		}

	}

	public static void main(String[] args) {
		Combination p = new Combination("cat");
		p.combine();
		p = new Combination("12345");
		p.combine();
		p = new Combination("");
		p.combine();
		p = new Combination(null);
		p.combine();

	}
}
