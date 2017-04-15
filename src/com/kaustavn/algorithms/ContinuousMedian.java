package com.kaustavn.algorithms;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ContinuousMedian {

	/*
	 * Given a unsorted array of size i, find the median value of all the
	 * subarrays from 0 to size i
	 * 
	 * Create two buckets. 1st bucket lowers will be a max heap. 2nd bucket
	 * highers will be a min heap.
	 * 
	 * Add the current element to lowers if it is lower its root(max value of
	 * that heap) else add to the higher element
	 * 
	 * if bucket sizes are equal then median is average of top elements of both
	 * heaps If bucket size is off by one , median is the top element to bigger
	 * heap
	 * 
	 * BUcket size difference can never be greater than 2. rebalance it
	 */

	public static double[] getMedians(int[] array) {
		// min heap
		PriorityQueue<Integer> highers = new PriorityQueue<Integer>();

		// max heap
		PriorityQueue<Integer> lowers = new PriorityQueue<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer a, Integer b) {
				return -1 * a.compareTo(b);
			}

		});

		double[] medians = new double[array.length];

		for (int i = 0; i < array.length; i++) {
			int number = array[i];
			addNumber(number, lowers, highers);
			reBalance(lowers, highers);
			medians[i] = getMedian(lowers, highers);
		}

		return medians;

	}

	private static double getMedian(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {

		/*
		 * compare the size of the heaps if same size ...average the top
		 * elements of both otherwise return the top element from bigger heap
		 */

		PriorityQueue<Integer> biggerHeap = lowers.size() > highers.size() ? lowers : highers;
		PriorityQueue<Integer> smallerHeap = lowers.size() > highers.size() ? highers : lowers;
		if (biggerHeap.size() == smallerHeap.size()) {
			return ((double) biggerHeap.peek() + (double) smallerHeap.peek()) / 2.0;
		}
		return biggerHeap.peek();

	}

	private static void reBalance(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
		// compare the sizes of the two heap
		// if they are off by one element or are of same size..its ok..return
		// if off by > 1 move one element from bigger to smaller heap

		PriorityQueue<Integer> biggerHeap = lowers.size() > highers.size() ? lowers : highers;
		PriorityQueue<Integer> smallerHeap = lowers.size() > highers.size() ? highers : lowers;

		if (biggerHeap.size() - smallerHeap.size() >= 2) {
			smallerHeap.add(biggerHeap.poll());
		}

	}

	private static void addNumber(int number, PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
		//
		if (lowers.size() == 0 || number < lowers.peek()) {
			lowers.add(number);
		} else
			highers.add(number);
	}

}
