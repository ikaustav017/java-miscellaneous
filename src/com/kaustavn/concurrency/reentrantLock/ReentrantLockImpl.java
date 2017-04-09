package com.kaustavn.concurrency.reentrantLock;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockImpl {
	private int count = 0;
	private Lock lock = new ReentrantLock();
	private Condition cond = lock.newCondition();

	public void increment() {
		for (int i = 0; i < 10000; i++)
			count++;
	}

	public void firstThread() throws InterruptedException {
		lock.lock();
		System.out.println("First thread waiting");
		cond.await();
		// will wait till the other thread unlocks the lock
		// && cond.signal has been called

		System.out.println("First thread rewoken");
		try {
			increment();
		} finally {
			// what if increment throws exception
			lock.unlock();
			// always put unlock in finally block so that it gets
			// executed no matter what

		}

	}

	public void secondThread() throws InterruptedException {

		Thread.sleep(2000);
		lock.lock();

		System.out.println("Press return key");
		new Scanner(System.in).nextLine();

		cond.signal();
		System.out.println("Signalled....");

		try {
			increment();
		} finally {
			lock.unlock();

		}

		System.out.println("Exiting second threat ...");

	}

	public void finished() {
		System.out.println("Count is " + count);
		System.out.println("All tasks completed!");
	}

}
