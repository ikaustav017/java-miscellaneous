package com.kaustavn.concurrency.threadPerformance;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WorkerLocks {

	private Random random = new Random();

	private List<Integer> list1 = new ArrayList<Integer>();
	private List<Integer> list2 = new ArrayList<Integer>();
	// good practice to use separate lock objects (instead of locking on actual
	// object list1)
	private Object lockOne = new Object();
	private Object lockTwo = new Object();

	// now the two different methods can be run in parallel by 2 different
	// threads
	public void stageOne() {
		synchronized (lockOne) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			list1.add(random.nextInt(100));
		}

	}

	public void stageTwo() {
		synchronized (lockTwo) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			list2.add(random.nextInt(100));
		}
	}

	public void process() {

		for (int i = 0; i < 1000; i++) {
			stageOne();
			stageTwo();
		}

	}

	public void main() {

		// two threads
		System.out.println("Starting process with two Thread (using two separate locks).... ");

		Thread t2 = new Thread(new Runnable() {
			public void run() {
				process();
			}
		});
		Thread t3 = new Thread(new Runnable() {
			public void run() {
				process();
			}
		});
		long start = System.currentTimeMillis();
		t2.start();
		t3.start();
		try {
			t2.join();
			t3.join();
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		System.out.println("List1: " + list1.size() + " list 2 " + list2.size());

		System.out.println("Timing " + (end - start));

	}
}
