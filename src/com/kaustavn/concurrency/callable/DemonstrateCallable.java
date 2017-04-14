package com.kaustavn.concurrency.callable;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class DemonstrateCallable {

	public void doRunnable() {
		ExecutorService executor = Executors.newCachedThreadPool();
		executor.submit(new Runnable() {
			@Override
			public void run() {
				System.out.println("Runnable Thread starting...");
				int duration = new Random().nextInt(4000);
				try {
					Thread.sleep(duration);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Runnable Thread ends...");
			}
		});
	}

	public void doCallable() {
		ExecutorService executor = Executors.newCachedThreadPool();

		// Specify what you want to return..in this example Integer
		Future<Integer> future = executor.submit(new Callable<Integer>() {
			@Override
			// Integer because you specified Integer when instantiating callbale
			public Integer call() throws IOException {
				System.out.println("Callable Thread starting...");
				int duration = new Random().nextInt(4000);
				if (duration > 2000) {
					throw new IOException("Callable thread Sleeping for too long (>2000ms): " + duration);
				}

				try {
					Thread.sleep(duration);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Callable thread ends...");

				return duration;
			}
		});

		executor.shutdown();
		try {
			System.out.println("Duration was :" + future.get());

			// get will block unitll the thread for that future has terminated
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {

			// if calls throws IOexcepion( or any other)
			// then this block will be executed
			IOException ex = (IOException) e.getCause();
			System.out.println("IOException Raised " + ex.getMessage());
		}

	}

	public void callableReturningNull() {

		ExecutorService executor = Executors.newCachedThreadPool();

		// Specify what you want to return..in this example Integer
		Future<?> fut = executor.submit(new Callable<Void>() {
			@Override
			// Integer because you specified Integer when instantiating callbale
			public Void call() throws IOException {
				System.out.println("Callable(returning null) Thread starting...");
				int duration = new Random().nextInt(4000);
				if (duration > 2000) {
					throw new IOException(
							"Callable(returning null)  thread Sleeping for too long (>2000ms): " + duration);
				}

				try {
					Thread.sleep(duration);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Callable(returning null)  thread ends...");
				return null;

			}
		});

		// if you dont want a return with calable
		// Future<?> fut = executor.submit(new Callable(Void)(){})
	}

	public static void main(String[] args) {
		DemonstrateCallable example = new DemonstrateCallable();
		example.doRunnable();
		// how can you make a thread return variable or handle an exception??
		// for that use callable

		for (int i = 0; i < 10; i++)
			example.doCallable();

		// example when callable does not want to return anything
		example.callableReturningNull();
	}

}
