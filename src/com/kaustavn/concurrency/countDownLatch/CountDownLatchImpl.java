package com.kaustavn.concurrency.countDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Processor implements Runnable {

	private CountDownLatch latch;
	private int id;
	int count = 0;

	public Processor(CountDownLatch latch, int id) {
		this.latch = latch;
		this.id = id;
	}

	@Override
	public void run() {
		System.out.println("Starting process....." + id);

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		count += 5;
		latch.countDown();
		System.out.println("Count is " + count);
		System.out.println("Ending process:  " + id);

	}

}

public class CountDownLatchImpl {

	public static void main(String[] args) {
		// CountDownLatch is threadsafe
		CountDownLatch latch = new CountDownLatch(3);

		ExecutorService executor = Executors.newFixedThreadPool(3);
		for (int i = 0; i < 10; i++) {
			executor.submit(new Processor(latch, i));
		}

		// waits till countdownlatch counted down to zero
		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Latch goes down to zero");

		// TODO Auto-generated method stub

	}

}
