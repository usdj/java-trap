package com.usdj.java.escape.reflect;

/**
 * <h1>People对象</h1>
 *
 * @author <a href="jaredtang93@gmail.com">JaredTang</a>
 * @since 1.8
 */
public class People {
	public String people(String hello) {
		return People.class.getName() + ":" + hello;
	}
}
