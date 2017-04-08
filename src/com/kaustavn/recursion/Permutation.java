package com.kaustavn.recursion;

public class Permutation {

	private String src;
	private StringBuilder out;
	private boolean[] flag;

	public Permutation(String src) {
		this.src = src;
		out = new StringBuilder();
		if (src != null)
			flag = new boolean[src.length()];
	}

	public void permute() {

		if (src == null) {
			return;
		}
		if (out.length() == src.length()) {
			System.out.println(out);
		}

		for (int i = 0; i < src.length(); i++) {
			if (flag[i]) {
				continue;
			}
			// select the first letter (c in cat)
			out.append(src.charAt(i));
			// set the flag for that letter to true to it is not picked up
			// in the interaction at next position (only a and t will be picked
			// at 2nd position)
			flag[i] = true;
			permute();
			// bring back the flag to false (c is false again now)
			flag[i] = false;
			// remove the last added character (c) so that next character a will
			// be picked at first position
			out.setLength(out.length() - 1);
		}
	}

	public static void main(String[] args) {
		Permutation p = new Permutation("cat");
		p.permute();
		p = new Permutation("12345");
		p.permute();
		p = new Permutation("");
		p.permute();
		p = new Permutation(null);
		p.permute();

	}

}