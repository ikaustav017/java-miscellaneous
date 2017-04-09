package com.kaustavn.concurrency.StartingThreads;

// Methods of creating threads in java
//2. implementing runnable and passing it in constructor of thread class

class Runner2 implements Runnable {
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
}

public class StartingThreadsByRunnable {
	public static void main(String[] args) {
		Thread t1 = new Thread(new Runner2());
		Thread t2 = new Thread(new Runner2());
		t1.start();
		t2.start();
	}

}
