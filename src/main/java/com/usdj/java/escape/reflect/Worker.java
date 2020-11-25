package com.usdj.java.escape.reflect;

/**
 * <h1>继承People的Worker对象</h1>
 *
 * @author <a href="jaredtang93@gmail.com">JaredTang</a>
 * @since 1.8
 */
public class Worker extends People {
	public String worker(String hello) {
		return Worker.class.getName() + ":" + hello;
	}
}
