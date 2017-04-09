package com.kaustavn.concurrency.StartingThreads;

public class StartingThreadByAnnonymousClass {

	// Methods of creating threads in java
	// 2. implementing runnable and passing it in constructor of thread class.
	// same as 2nd method just avoiding creating a new class

	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println("Hello " + i);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.getMessage();
					}

				}
			}

		});

		t1.start();

	}

}
