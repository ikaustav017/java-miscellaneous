package com.kaustavn.concurrency.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Processor implements Runnable {

	private int id;
	int count = 0;

	public Processor(int id) {
		this.id = id;
	}

	@Override
	public void run() {
		System.out.println("Starting process:  " + id);

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		count += 5;
		System.out.println("Count is " + count);
		System.out.println("Ending process:  " + id);

	}

}

public class ExecutorServiceImpl {

	public static void main(String[] args) {

		// initialize two workers
		ExecutorService executor = Executors.newFixedThreadPool(2);

		// and there are 5 tasks. so threads will be recycled
		// when worker 1 is done first task, it will be assigned 3rd task
		for (int i = 0; i < 5; i++) {
			executor.submit(new Processor(i));
		}
		executor.shutdown();
		System.out.println("All tasks submitted");

		// wait for one day
		try {
			executor.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("All tasks completed");
	}

}
