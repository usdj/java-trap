package com.usdj.java.escape.function_interface_lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <h1>Lambda表达式的使用</h1>
 *
 * @author <a href="jaredtang93@gmail.com">JaredTang</a>
 * @since 1.8
 */
public class StudyLambda {

	/**
	 * <h2>Java 1.8之前创建线程</h2>
	 */
	private static void baseUsage() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Anonymous Class Thread run()");
			}
		}).start();
	}

	/**
	 * <h2>Java 8创建线程</h2>
	 */
	private static void lambdaUsage() {
		new Thread(() -> {
			System.out.println("Anonymous Class Thread run()");
		}).start();
	}

	/**
	 * <h2>按照字符串长度进行排序</h2>
	 */
	private static void myCompare() {
		// Java 8之前
		List<String> stringList = Arrays.asList("z", "y", "x", "a", "b");
		Collections.sort(stringList, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				if (s1 == null) {
					return -1;
				}
				if (s2 == null) {
					return  -1;
				}
				return s1.length() - s2.length();
			}
		});

		// java8 使用lambda表达式去实现
		Collections.sort(stringList,(s1,s2) -> {
			if (s1 == null) {
				return -1;
			}
			if (s2 == null) {
				return  -1;
			}
			return s1.length() - s2.length();
		});
	}

	/**
	 * <h2>理解stream的中间操作和结束操作</h2>
	 */
	private static void howToUseLambda() {
		List<String> stringList = Arrays.asList("hello", "world");
		List<String> newStringList = stringList.stream().filter(n -> n.startsWith("h"))
				.map(n -> n.toUpperCase())
				.collect(Collectors.toList());
		System.out.println(newStringList);
	}

	/**
	 * <h2>Stream和lambda可能导致计算低效</h2>
	 */
	private static void badUseLambda() {

		List<String> stringList = Arrays.asList("hello123", "world");
		int longestNameSize = stringList.stream()
				.filter(s -> s.startsWith("h"))
				.mapToInt(String::length)
				.max()
				.getAsInt();

		// 通过迭代器
		int longest = 0;
		for (String s : stringList) {
			if (s.startsWith("h")) {
				int len = s.length();
				longest = Math.max(len,longest);
			}
		}
		System.out.println(longest);
	}
}
