package com.usdj.java.escape;

/**
 * <h1>Java异常处理</h1>
 *
 * @author <a href="jaredtang93@gmail.com">JaredTang</a>
 * @since 1.8
 */
@SuppressWarnings("all")
public class ExceptionProcess {
	private static class User {}

	/**
	 * <h2>Java异常本质 -- 抛出异常</h2>
	 */
	private void throwException() {
		User user = null;
		// ...
		if (null == user) {
			throw new NullPointerException();
		}
	}

	/**
	 * <h2>不能捕获空指针异常</h2>
	 */
	private void canNotCatchException() {
		try {
			throwException();
		} catch (ClassCastException cce) {
			System.out.println(cce.getMessage());
			System.out.println(cce.getClass().getName());
		}
	}

	/**
	 * <h2>捕获空指针异常</h2>
	 */
	private void canCatchNpeException() {
		try {
			throwException();
		} catch (ClassCastException cce) {
			// 可以捕获多个异常类
			System.out.println(cce.getMessage());
			System.out.println(cce.getClass().getName());
		} catch (NullPointerException npe) {
			System.out.println(npe.getMessage());
			System.out.println(npe.getClass().getName());
		}
	}

	public static void main(String[] args) {
		ExceptionProcess process = new ExceptionProcess();
		process.canCatchNpeException();
		process.canNotCatchException();
	}
}
