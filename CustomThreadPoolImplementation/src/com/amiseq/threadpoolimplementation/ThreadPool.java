package com.amiseq.threadpoolimplementation;

import java.util.Scanner;

import com.amiseq.threadpoolexceptions.InvalidThreadPoolSize;

public class ThreadPool {
    public static void main(String[] args) throws Exception{
    	System.out.println("Please provide thread pool size");
    	Scanner scan = new Scanner(System.in);
    	int threadPoolSize = scan.nextInt();
    	if(threadPoolSize <= 0) {
    		throw new InvalidThreadPoolSize("Please Provide Thread Pool Size Greater than 0");
    	}
    	CustomThreadPoolImplementation customThreadPoolImplementation = new CustomThreadPoolImplementation();
    	customThreadPoolImplementation.addTask(() -> System.out.println("First print task"));
    	customThreadPoolImplementation.addTask(() -> System.out.println("Second print task"));
    	customThreadPoolImplementation.addTask(() -> System.out.println("Third print task"));
    	customThreadPoolImplementation.addTask(() -> System.out.println("Fourth print task"));
    	customThreadPoolImplementation.addTask(() -> System.out.println("Fifth print task"));
    	customThreadPoolImplementation.addTask(() -> System.out.println("Sixth print task"));
    	customThreadPoolImplementation.addTask(() -> System.out.println("Seventh print task"));
    	customThreadPoolImplementation.addTask(() -> System.out.println("Eigth print task"));
    	customThreadPoolImplementation.createThreadPool(threadPoolSize);
    	customThreadPoolImplementation.runTask();
    }

}
