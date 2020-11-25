package com.usdj.java.escape.synchronized_;

/**
 * <h1>对 value进行减法操作</h1>
 *
 * @author <a href="jaredtang93@gmail.com">JaredTang</a>
 * @since 1.8
 */
public class Active implements Runnable{

	private int value = 1000;

	@Override
	public void run() {
		String name = Thread.currentThread().getName();

		while (true) {
			if (value > 0) {
				System.out.println(name + " start :" + value);
				value--;
				System.out.println(name + " done :" + value);
			} else {
				break;
			}
		}

	}
}
