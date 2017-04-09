package com.kaustavn.concurrency.threadPerformance;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Worker {

	private Random random = new Random();

	private List<Integer> list1 = new ArrayList<Integer>();
	private List<Integer> list2 = new ArrayList<Integer>();

	public void stageOne() {
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		list1.add(random.nextInt(100));
	}

	public void stageTwo() {
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

		// without threads
		System.out.println("Stating process...");
		long start = System.currentTimeMillis();
		process();
		long end = System.currentTimeMillis();
		System.out.println("List1: " + list1.size() + " list 2 " + list2.size());
		System.out.println("Timing " + (end - start));

		// just one thread
		System.out.println("Starting process with one Thread");

		Thread t1 = new Thread(new Runnable() {
			public void run() {
				process();
			}
		});
		start = System.currentTimeMillis();
		t1.start();
		try {
			t1.join();
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		end = System.currentTimeMillis();
		System.out.println("List1: " + list1.size() + " list 2 " + list2.size());

		System.out.println("Timing " + (end - start));

	}

}
