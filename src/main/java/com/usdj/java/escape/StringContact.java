package com.usdj.java.escape;

/**
 * <h1>字符串拼接</h1>
 *
 * @author <a href="jaredtang93@gmail.com">JaredTang</a>
 * @since 1.8
 */
public class StringContact {

	private static void easyContact() {
		String userName = "jared";
		String age = "25";
		String job = "Developer";
		String info = userName + age + job;
		System.out.println(info);
	}

	// 虽然隐式调用，jvm也会对此进行优化使用Stringbuilder,但在循环中new,性能开销大
	private static void implicitUseStringBuilder(String[] values) {
		String result = "";
		for (int i = 0; i < values.length; i++) {
			result += values[i];
		}
		System.out.println(result);
	}

	// 显式调用，优化后
	private static void explicitUseStringBuilder(String[] values) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < values.length; i++) {
			result.append(values[i]);
		}
		System.out.println(result.toString());
	}
}
