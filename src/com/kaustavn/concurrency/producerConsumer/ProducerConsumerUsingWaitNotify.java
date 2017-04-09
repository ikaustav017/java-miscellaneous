package com.kaustavn.concurrency.producerConsumer;

import java.util.LinkedList;
import java.util.Random;

public class ProducerConsumerUsingWaitNotify {
	private LinkedList<Integer> list = new LinkedList<Integer>();
	private final int LIMIT = 10;
	private Object lock = new Object();

	public void produce() throws InterruptedException {
		int value = 0;
		while (true) {

			synchronized (lock) {
				while (list.size() == LIMIT) {

					// goes to sleep if list is full
					lock.wait();
					// surrounded in while loop to confirm that the condition
					// that put you to sleep in first place is not valid anymore
				}
				list.add(value++);
				lock.notify();
			}

		}
	}

	public void consume() throws InterruptedException {

		Random random = new Random();

		while (true) {
			synchronized (lock) {
				while (list.size() == 0) {
					lock.wait();
				}
				System.out.println("List size is :" + list.size());
				int value = list.removeFirst();
				lock.notify();
				System.out.println("Value removed" + " is " + value);
				lock.notify();
			}

			Thread.sleep(random.nextInt(1000));
		}
	}

}
