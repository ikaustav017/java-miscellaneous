package com.kaustavn.concurrency.threadInterrupted;

import java.util.Random;

public class DemonstrateThreadInterruption {

	public static void main(String[] args) {
		System.out.println("Starting...");

		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				Random random = new Random();

				// some heavy task
				for (int i = 0; i < 1E8; i++) {
					if (Thread.currentThread().isInterrupted()) {
						System.out.println("Thread 1 is interrupted!");
						break;
					}
					Math.sin(random.nextDouble());
				}
			}
		});

		t1.start();

		try {
			Thread.sleep(4000);
			// only sets a flag interrupted = true. it does not automatically
			// interrupt
			// you need to detect the flag change and respond accordingly
			t1.interrupt();

			t1.join();

		} catch (InterruptedException e) {

		}
		System.out.println("Finishing...");

		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {

				// some heavy task
				for (int i = 0; i < 1E8; i++) {
					try {
						Thread.sleep(1);
						// sleep automatically detects change in interrupt flag
					} catch (InterruptedException e) {
						System.out.println("Thread2 is interrupted!");
						break;
					}
				}
			}
		});

		System.out.println("Starting thread 2...");
		t2.start();

		try {
			Thread.sleep(500);

			t2.interrupt();
			t2.join();
		} catch (InterruptedException e) {

		}
		System.out.println("Finishing thread 2...");
	}

}
