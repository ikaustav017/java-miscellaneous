package com.kaustavn.concurrency;

public class BestDiningPhilospher {
	Object[] forks;
	Philosopher[] philosophers;
	int[] numOfTimes;

	public BestDiningPhilospher(int num) {
		forks = new Object[num];
		philosophers = new Philosopher[num];
		numOfTimes = new int[num];
		for (int i = 0; i < num; i++) {
			forks[i] = new Object();
			int fork1 = i;
			int fork2 = (i + 1) % num;
			if (i % 2 == 0) {
				philosophers[i] = new Philosopher(i, fork2, fork1);
			} else {
				philosophers[i] = new Philosopher(i, fork1, fork2);
			}

		}
	}

	public void startEating() throws InterruptedException {
		for (int i = 0; i < philosophers.length; i++) {
			philosophers[i].start();
		}
		philosophers[0].join();

	}

	public static void main(String[] args) {
		try {
			BestDiningPhilospher d1 = new BestDiningPhilospher(5);
			d1.startEating();

		} catch (InterruptedException ex) {

		}

	}

	public class Philosopher extends Thread {

		int id;
		int fork1;
		int fork2;

		public Philosopher(int id, int f1, int f2) {
			this.id = id;
			this.fork1 = f1;
			this.fork2 = f2;
		}

		public void status(String status) {
			System.out.println("Status is :" + status);
		}

		public void run() {
			// status("Philosopher "+id+" is beginning to eat with fork "+fork1+
			// " and fork " +fork2);

			while (true) {
				// status("Philosopher "+id+" is Picking up fork "+fork1 );
				synchronized (forks[fork1]) {
					// status("Philosopher "+id+" is Picking up next fork "+
					// fork2);
					synchronized (forks[fork2]) {
						// status("Philosopher "+id + " is eating");
						status("Philosopher " + id + " has eaten for " + ++numOfTimes[id]);
					}

				}
			}

		}
	}
}