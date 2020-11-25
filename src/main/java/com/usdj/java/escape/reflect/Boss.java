package com.usdj.java.escape.reflect;

/**
 * <h1>继承自Woker的Boss对象</h1>
 *
 * @author <a href="jaredtang93@gmail.com">JaredTang</a>
 * @since 1.8
 */
public class Boss extends Worker{
	public String boss(String hello) {
		return Boss.class.getName() + ":" + hello;
	}

	public String numeric(int age) {
		return Boss.class.getName() + ":" + age;
	}
}
