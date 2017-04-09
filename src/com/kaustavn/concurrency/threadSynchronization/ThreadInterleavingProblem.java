package com.kaustavn.concurrency.threadSynchronization;

public class ThreadInterleavingProblem {

	private int count = 0;

	// in this case volatile will not help because the issue is not caching

	public int getCount() {
		return count;
	}

	public void incrementCount() {
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 10000; i++) {
					count++;
					// count++ is not an atomic operation
					// 1. fetch count 2. increment count 3. store the new value
					// Both thread can pick up value 100 and then increment it
					// and result will be 101 (not 102)
				}

			}

		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 10000; i++) {
					count++;
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

		for (int i = 0; i < 100; i++) {
			ThreadInterleavingProblem t = new ThreadInterleavingProblem();
			t.incrementCount();
			if (t.getCount() != 20000) {
				System.out.println("Ahha...Thread interleaving " + t.getCount());
			}
		}
		// TODO Auto-generated method stub

	}

}
