package com.kaustavn.concurrency.semaphores;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/*
 * Locks: acquire and release have to be done in the same thread
 * Semaphores: acquire release can be done by different threads
 * Semaphore(1) is same as lock
 */
public class DemonstrateSemaphore {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newCachedThreadPool();
		// stating 100 threads at once. Semaphore will only allow 10 at a time.
		// without semaphore, everyone will get access immediately
		for (int i = 0; i < 100; i++) {
			executor.submit(new Runnable() {
				@Override
				public void run() {
					SingletonConnection.getInstance().connect();
				}
			});
		}

		// managerial thread finishes when threads finishes
		executor.shutdown();
		try {
			executor.awaitTermination(1, TimeUnit.MINUTES);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
