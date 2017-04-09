package com.kaustavn.concurrency.threadSynchronization;

public class ThreadInterleavingSolution {

	private int count = 0;

	// in this case volatile will not help because the issue is not caching

	public int getCount() {
		return count;
	}

	public synchronized void increment() {
		count++;
	}

	public void doWork() {
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 10000; i++) {
					increment();
				}

			}

		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 10000; i++) {
					increment();
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

	}

	public static void main(String[] args) {

		for (int i = 0; i < 1000; i++) {
			ThreadInterleavingSolution t = new ThreadInterleavingSolution();
			t.doWork();
			if (t.getCount() != 20000) {
				System.out.println("Ahha...Thread interleaving " + t.getCount());
			} else {
				System.out.println("No more Thread interleaving " + t.getCount());
			}
		}
		// TODO Auto-generated method stub

	}

}
