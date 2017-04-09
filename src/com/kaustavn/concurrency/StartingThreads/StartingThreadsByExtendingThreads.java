package com.kaustavn.concurrency.StartingThreads;

//Methods of creating threads in java
//1. By extending Thread class

class Runner extends Thread {
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

public class StartingThreadsByExtendingThreads {
	public static void main(String[] args) {

		Runner r1 = new Runner();
		r1.start();
		// dont call run ..it will run your code but in the main thread of the
		// application
		// start will make it run in it's own thread

		Runner r2 = new Runner();
		r2.start();
	}

}
