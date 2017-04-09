package com.kaustavn.concurrency.threadPerformance;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Worker().main();
		new WorkerSynchronized().main();
		new WorkerLocks().main();
	}

}
