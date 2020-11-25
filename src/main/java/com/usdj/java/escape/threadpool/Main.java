package com.usdj.java.escape.threadpool;

import java.util.concurrent.ExecutorService;

/**
 * <h1>可监控的线程池</h1>
 *
 * @author <a href="jaredtang93@gmail.com">JaredTang</a>
 * @since 1.8
 */
public class Main {
	public static void main(String[] args) {
		ExecutorService executorService = ExecutorsUtil.newFixedThreadPool(10,"jared-pool");
		Runnable runnable1 = new Reading(3,"Java编程思想");
		Runnable runnable2 = new Reading(2,"Spring实战");
		Runnable runnable3 = new Reading(3,"SpringBoot实战");
		Runnable runnable4 = new Reading(1,"MySql权威指南");
		Runnable runnable5 = new Reading(2,"SpringCloud实战");
		executorService.execute(runnable1);
		executorService.execute(runnable2);
		executorService.execute(runnable3);
		executorService.execute(runnable4);
		executorService.execute(runnable5);
		executorService.shutdown();
	}
}
