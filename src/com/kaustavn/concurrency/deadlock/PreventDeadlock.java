package com.kaustavn.concurrency.deadlock;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PreventDeadlock {

	Account acc1;
	Account acc2;

	public PreventDeadlock() {
		acc1 = new Account(0, 20000);
		acc2 = new Account(0, 20000);
	}

	private Lock lock1 = new ReentrantLock();
	private Lock lock2 = new ReentrantLock();

	public void acquireLocks(Lock lock1, Lock lock2) throws InterruptedException {
		while (true) {

			boolean flagAcc1 = false;
			boolean flagAcc2 = false;

			try {
				flagAcc1 = lock1.tryLock();
				flagAcc2 = lock2.tryLock();
			} finally {
				if (flagAcc1 && flagAcc2) {
					return;
				}
				// unlock the locks which you got
				if (flagAcc1) {
					lock1.unlock();

				}
				if (flagAcc2) {
					lock2.unlock();
				}

			}

			Thread.sleep(1);
		}
	}

	public void deposit() throws InterruptedException {
		Random random = new Random();
		// get first lock and then get 2nd lock
		acquireLocks(lock1, lock2);
		try {
			for (int i = 0; i < 100; i++)
				Account.transfer(acc1, acc2, random.nextInt(100));
		} finally {
			lock1.unlock();
			lock2.unlock();
		}
	}

	public void withdraw() throws InterruptedException {
		Random random = new Random();
		// get 2nd lock first and then get lock 1
		acquireLocks(lock2, lock1);
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

	public static void main(String[] args) {

		for (int i = 0; i < 10000; i++) {
			System.out.println("Attempt " + i + "  of 10000");
			PreventDeadlock dl = new PreventDeadlock();

			Thread t1 = new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						dl.deposit();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});

			Thread t2 = new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						dl.withdraw();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});

			t1.start();
			t2.start();

			try {
				t1.join();
				t2.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}

			dl.showBalance();
		}

	}

}
