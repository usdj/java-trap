package com.usdj.java.escape.threadpool;

import java.util.concurrent.*;

/**
 * <h1>简单使用线程池</h1>
 *
 * @author <a href="jaredtang93@gmail.com">JaredTang</a>
 * @since 1.8
 */
@SuppressWarnings("all")
public class EasyUseThreadPool {

	/**
	 * 使用固定大小线程池
	 * 当任务越来越多，那么更多的任务会被加入到阻塞队列中，持续阻塞队列增长内存越来越大，容易导致gc、oom
	 * @param threadCount
	 */
	private static void useFixedThreadPool(int threadCount){
		ExecutorService executorService = Executors.newFixedThreadPool(threadCount);
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

	/**
	 * <h2>自定义线程池</h2>
	 * 出现线程池和队列满的情况，会发生线程拒绝的情况
	 */
	private static void customThreadPool(){
		ThreadPoolExecutor custom1 = new ThreadPoolExecutor(1,1,30, TimeUnit.MINUTES,
				new ArrayBlockingQueue<>(2)
		);

		ThreadPoolExecutor custom2 = new ThreadPoolExecutor(1,1,30, TimeUnit.MINUTES,
				new ArrayBlockingQueue<>(2),
				new CustomRejectHandler()
		);

		for (int i = 0; i < 5; i++) {
//			custom1.execute(new Reading(3,"Java编程思想"));
			 custom2.execute(new Reading(3,"Java编程思想"));
		}
//		custom1.shutdown();
		custom2.shutdown();
	}

	private static class CustomRejectHandler implements RejectedExecutionHandler {
		@Override
		public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
			// 使线程队列处于等待状态
			try {
				executor.getQueue().put(r);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
//		useFixedThreadPool(3);
		customThreadPool();
	}
}
