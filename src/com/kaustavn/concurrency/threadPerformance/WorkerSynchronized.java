package com.kaustavn.concurrency.threadPerformance;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WorkerSynchronized {

	private Random random = new Random();

	private List<Integer> list1 = new ArrayList<Integer>();
	private List<Integer> list2 = new ArrayList<Integer>();

	// synchronized acquires monitor lock of Worker object
	// if thread 1 obtains lock and enters stage one,
	// thread 2 cannot enter stageTwo (even though the methods are independent)
	// since there is only one lock
	public synchronized void stageOne() {
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		list1.add(random.nextInt(100));
	}

	public synchronized void stageTwo() {
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		list2.add(random.nextInt(100));
	}

	public void process() {

		for (int i = 0; i < 1000; i++) {
			stageOne();
			stageTwo();
		}

	}

	public void main() {

		// just one thread
		System.out.println("Starting sync process with one Thread");

		Thread t1 = new Thread(new Runnable() {
			public void run() {
				process();
			}
		});
		long start = System.currentTimeMillis();
		t1.start();
		try {
			t1.join();
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		System.out.println("List1: " + list1.size() + " list 2 " + list2.size());

		System.out.println("Timing " + (end - start));

		// two threads
		System.out.println("Starting syncProcess with two Thread (takes twice amt of what's expected)");

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
		start = System.currentTimeMillis();
		t2.start();
		t3.start();
		try {
			t2.join();
			t3.join();
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		end = System.currentTimeMillis();
		System.out.println("List1: " + list1.size() + " list 2 " + list2.size());

		System.out.println("Timing " + (end - start));

	}
}
