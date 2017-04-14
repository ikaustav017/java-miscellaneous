package com.kaustavn.concurrency.deadlock;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DemonstrateDeadLock {

	Account acc1;
	Account acc2;

	public DemonstrateDeadLock() {
		acc1 = new Account(0, 20000);
		acc2 = new Account(0, 20000);
	}

	private Lock lock1 = new ReentrantLock();
	private Lock lock2 = new ReentrantLock();

	public void depositByThreadOne() {
		Random random = new Random();
		// get first lock and then get 2nd lock
		lock1.lock();
		lock2.lock();
		try {
			for (int i = 0; i < 100; i++)
				Account.transfer(acc1, acc2, random.nextInt(100));
		} finally {
			lock1.unlock();
			lock2.unlock();
		}
	}

	public void withdrawByThreadTwo() {
		Random random = new Random();
		// get 2nd lock first and then get lock 1
		lock2.lock();
		lock1.lock();
		try {
			for (int i = 0; i < 100; i++)
				Account.transfer(acc2, acc1, random.nextInt(100));
		} finally {

			lock2.unlock();
			lock1.unlock();
		}
	}

	public void showBalance() {
		System.out.println("Balance  " + acc1.getId() + "  is : " + acc1.getBalance());
		System.out.println("Balance  " + acc2.getId() + "  is : " + acc2.getBalance());
		System.out.println("Total Balance " + (acc1.getBalance() + acc2.getBalance()));
	}

	public static void main(String[] args) throws InterruptedException {

		for (int i = 0; i < 10000; i++) {
			System.out.println("Attempt " + i + "  of 10000");
			DemonstrateDeadLock dl = new DemonstrateDeadLock();

			Thread t1 = new Thread(new Runnable() {
				@Override
				public void run() {
					dl.depositByThreadOne();
				}
			});

			Thread t2 = new Thread(new Runnable() {
				@Override
				public void run() {
					dl.withdrawByThreadTwo();
				}
			});

			t1.start();
			t2.start();

			t1.join();
			t2.join();
			dl.showBalance();
		}

	}

}
