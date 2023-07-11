package com.amiseq;

import java.util.ArrayList;

class CustomThreadPoolImplementation implements Runnable {
	private ArrayList<Tasks> taskList = new ArrayList<>();
	private Thread[] workerThreads;
	private int noOfThreads;
	Runnable r;

	public CustomThreadPoolImplementation() {

	}

	public CustomThreadPoolImplementation(int noOfThreads) {
		super();
		this.noOfThreads = noOfThreads;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			createThreadPool(noOfThreads);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		runTask();
		for (int i = 0; i < 8; i++) {
             int msg = i+1;
			Tasks task = (String message) -> msg + message;
			addTask(task);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void addTask(Tasks task) {
		this.taskList.add(task);
		synchronized (this.r) {
			this.r.notifyAll();
		}

	}

	public void createThreadPool(int numThreads) throws InterruptedException {
		this.workerThreads = new Thread[numThreads];
		this.r = new ThreadExecutor(taskList);
		for (int i = 0; i < numThreads; i++) {
			workerThreads[i] = new Thread(r);

		}
	}

	public void runTask() {

		for (Thread t : workerThreads) {
			t.start();
		}
	}


}
