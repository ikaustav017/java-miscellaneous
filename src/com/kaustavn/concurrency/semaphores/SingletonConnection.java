package com.kaustavn.concurrency.semaphores;

import java.util.concurrent.Semaphore;

public class SingletonConnection {

	// ten threads can access your code at same time
	// fairness parameter true, first thread to request guarented to get
	// access first
	private static SingletonConnection instance = new SingletonConnection();

	// only 10 threads can connect at once
	private Semaphore sem = new Semaphore(10, true);
	private int connections = 0;

	private SingletonConnection() {
	}

	public static SingletonConnection getInstance() {
		return instance;
	}

	public void connect() {
		try {
			sem.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			doConnect();
		} finally {
			// even if doConnect throws exception, this block will get executed
			sem.release();
		}
	}

	public void doConnect() {

		synchronized (this) {
			connections++;
			System.out.println("Current connections are: " + connections);
		}
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		synchronized (this) {
			connections--;
		}

	}

}
