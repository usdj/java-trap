package com.usdj.java.escape.synchronized_;

/**
 * <h1>演示子类是否能继承synchronized</h1>
 *
 * @author <a href="jaredtang93@gmail.com">JaredTang</a>
 * @since 1.8
 */
public class SubActive extends MainActive{
	private int value = 1000;

	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		while (true) {
			if (value > 0) {
				System.out.println(name + "start : " + value);
				value --;
				System.out.println(name + "done : " + value );
			} else {
				break;
			}
		}
	}

}
