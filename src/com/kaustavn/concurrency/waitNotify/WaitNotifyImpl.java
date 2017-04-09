package com.kaustavn.concurrency.waitNotify;

import java.util.Scanner;

public class WaitNotifyImpl {

	public void produce() throws InterruptedException {
		synchronized (this) {
			System.out.println("Producer obtained lock and is running");
			// wait is very resource efficient and can be called within
			// synchronized block
			// it relinquishes lock to other threads
			wait();
			System.out.println("Resumed.");
		}

	}

	public void consume() throws InterruptedException {

		Scanner scan = new Scanner(System.in);

		// so that producer runs first
		Thread.sleep(2000);

		synchronized (this) {
			System.out.println("Waiting for return key");
			scan.nextLine();
			System.out.println("return key pressed");

			// can only be called within synchronized code block
			// it does not relinquish lock.
			// use noptifyAll if there are multiple threads waiting on this lock
			notify();
			Thread.sleep(5000); // to confirm that notify does not relinquishes
								// the lock

		} // exits the synchronized blocks and now waiting thread can resume
	}

}
