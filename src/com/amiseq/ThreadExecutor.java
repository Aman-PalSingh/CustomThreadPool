package com.amiseq;

import java.util.ArrayList;

class ThreadExecutor implements Runnable {
	private ArrayList<Tasks> taskList = new ArrayList<>();

	public ThreadExecutor(ArrayList<Tasks> taskList) {
		super();
		this.taskList = taskList;
	}

	public void run() {
		while (true) {
			synchronized (this) {
				try {
					while (taskList.size() == 0) {
						this.wait();
					}
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println(taskList.remove(0).printMessage(" Print Task"));
				

			}
		}

	}

}
