package com.usdj.java.escape;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <h1>多线程下的变量值更新</h1>
 *
 * @author <a href="jaredtang93@gmail.com">JaredTang</a>
 * @since 1.8
 */
public class Atomic_ {

	private static int count = 0;
	private static AtomicInteger atomicInteger = new AtomicInteger(0);

	/**
	 * <h2>线程不安全的累加</h2>
	 */
	private static void accumulator(int acc) throws Exception {
		CountDownLatch cd1 = new CountDownLatch(2);
		Thread t1 = new Thread(() -> {
			for (int i = 0; i < acc; i++) {
				count++;
			}
			cd1.countDown();
		});
		Thread t2 = new Thread(() -> {
			for (int i = 0; i < acc; i++) {
				count++;
			}
			cd1.countDown();
		});

		t1.start();
		t2.start();
		// 进行线程阻塞，当countdown值为0才释放回主线程
		cd1.await();

		System.out.println("result :" + count);
	}

	/**
	 * 使用原子类累加
	 * @param acc
	 * @throws Exception
	 */
	private static void atomicAccumulator(int acc) throws Exception {
		CountDownLatch cd1 = new CountDownLatch(2);
		Thread t1 = new Thread(() -> {
			for (int i = 0; i < acc; i++) {
				atomicInteger.incrementAndGet();
			}
			cd1.countDown();
		});
		Thread t2 = new Thread(() -> {
			for (int i = 0; i < acc; i++) {
				atomicInteger.incrementAndGet();
			}
			cd1.countDown();
		});

		t1.start();
		t2.start();
		// 进行线程阻塞，当countdown值为0才释放回主线程
		cd1.await();

		System.out.println("result :" + atomicInteger.get());

	}

	public static void main(String[] args) throws Exception {
//		accumulator(100000);
		atomicAccumulator(100000);
	}
}
