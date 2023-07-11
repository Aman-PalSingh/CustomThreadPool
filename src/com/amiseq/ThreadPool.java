package com.amiseq;

import java.util.Scanner;

import com.amiseq.exceptions.InvalidThreadPoolSize;


public class ThreadPool {
	public static void main(String[] args) throws Exception {
		System.out.println("Please provide thread pool size");
		Scanner scan = new Scanner(System.in);
		int threadPoolSize = scan.nextInt();
		if (threadPoolSize <= 0 || threadPoolSize > 16) {
			throw new InvalidThreadPoolSize("Please Provide Thread Pool Size Greater than 0 and less than 16");
		}
		Runnable customThreadPoolImplementation = new CustomThreadPoolImplementation(threadPoolSize);
		Thread thread = new Thread(customThreadPoolImplementation);
	
		thread.start();
		
	
	

		
	}

}
