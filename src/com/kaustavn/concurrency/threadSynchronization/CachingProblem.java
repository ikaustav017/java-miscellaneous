package com.kaustavn.concurrency.threadSynchronization;

import java.util.Scanner;

class Processor extends Thread {

	// Java (for optimizing) might cache this variable so when you call
	// shutdown,
	// it might never detect the change when you call shutdown

	// private boolean running = true;

	// use volatile keyword to ensure java does not cache variable

	private volatile boolean running = true;

	public void run() {
		while (running) {
			System.out.println("Hello!");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.getMessage();
			}
		}
	}

	public void shutdown() {
		running = false;
	}

}

public class CachingProblem {

	public static void main(String[] args) {
		Processor proc1 = new Processor();
		proc1.start();

		System.out.println("Please press returnn to stop ...");
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();

		proc1.shutdown();

		// TODO Auto-generated method stub

	}

}
