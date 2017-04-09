package com.kaustavn.concurrency.reentrantLock;

public class DemonstrateReEntrantLock {

	public static void main(String[] args) {

		ReentrantLockImpl lock = new ReentrantLockImpl();
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					lock.firstThread();
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
					lock.secondThread();

				} catch (InterruptedException e) {
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
			e.printStackTrace();
		}

		lock.finished();

	}

}
