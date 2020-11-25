package com.usdj.java.escape.synchronized_;

/**
 * <h1>synchronized多线程Main</h1>
 *
 * @author <a href="jaredtang93@gmail.com">JaredTang</a>
 * @since 1.8
 */
public class MainActive implements Runnable {

	private int value = 0;

	@Override
	public synchronized void run() {
		String name = Thread.currentThread().getName();
		while (true) {
			if (value < 1000) {
				System.out.println(name + "start : " + value);
				value ++;
				System.out.println(name + "done : " + value );
			} else {
				break;
			}
		}
	}
}
