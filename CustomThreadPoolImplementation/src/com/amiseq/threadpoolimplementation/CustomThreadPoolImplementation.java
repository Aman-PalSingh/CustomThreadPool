package com.amiseq.threadpoolimplementation;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class CustomThreadPoolImplementation {
	private BlockingQueue<Runnable> workerQueue = new LinkedBlockingQueue<>();
	private Thread[] workerThreads;
	private int noOfThreads;

	public CustomThreadPoolImplementation() {

	}

	public void addTask(Runnable r) {
		try {
			this.workerQueue.put(r);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void createThreadPool(int numThreads) throws InterruptedException {
		this.workerThreads = new Thread[numThreads];
		noOfThreads = numThreads;
	}

	public void runTask() {
		for (Thread t : workerThreads) {
			t = new ThreadExecutor("Custom Threads");
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			t.start();
		}
	}

	class ThreadExecutor extends Thread {
		public ThreadExecutor(String name) {
			super(name);
		}

		public void run() {
			while (true) {
				try {
					workerQueue.take().run();
                  Thread.sleep(1000*noOfThreads);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}
	}
}
