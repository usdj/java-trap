package com.usdj.java.escape.thread_local;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <h1>在线程池中使用ThreadLocal</h1>
 *
 * @author <a href="jaredtang93@gmail.com">JaredTang</a>
 * @since 1.8
 */
@SuppressWarnings("all")
public class ThreadLocalValueHolder {

	private static final ThreadLocal<Integer> holer = ThreadLocal.withInitial(
			() -> 0
	);

	public static int getValue() {
		return holer.get();
	}

	public static void remove() {
		holer.remove();
	}

	public static void increment() {
		holer.set(holer.get() + 1);
	}

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		for (int i = 0; i < 15; i++) {
			executorService.execute(
//					() -> {
//						long threadId = Thread.currentThread().getId();
//						int before = getValue();
//						increment();
//						int after = getValue();
////						System.out.println("Before: " + before + ", after: " + after);
//						// ThreadLocal没有及时清理现场，前后值不是0、1
//						System.out.println("ThreadId:" + threadId + ",before: " + before + ", after: " + after);
//					}
					// 线程池中及时清理现场
					() -> {
						try {
							long threadId = Thread.currentThread().getId();
							int before = getValue();
							increment();
							int after = getValue();
							System.out.println("ThreadId:" + threadId + ",before: " + before + ", after: " + after);
						} finally {
							remove();
						}
					}
			);
		}
		executorService.shutdown();
	}
}
