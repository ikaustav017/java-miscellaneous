package com.kaustavn.concurrency.producerConsumer;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerUsingBlockingQueue {

	// thread-safe implementation of queue
	private BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);

	public void produce() throws InterruptedException {
		while (true) {
			Random random = new Random();
			Integer value = random.nextInt(100);
			queue.put(value);
			// put will wait if queue is full
			System.out.println("Queue size after adding value " + value);
		}

	}

	public void consume() throws InterruptedException {
		while (true) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Random random = new Random();
			if (random.nextInt(10) == 0) {
				Integer value = queue.take();
				// take will wait if queue is empty
				System.out.println("Queue size after consuming value " + value + " is " + queue.size());
			}

		}
	}

	public static void main(String[] args) throws InterruptedException {
		ProducerConsumerUsingBlockingQueue pc = new ProducerConsumerUsingBlockingQueue();
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					pc.produce();
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
					pc.consume();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		t1.start();
		t2.start();

		t1.join();
		t2.join();

	}

}
