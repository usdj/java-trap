package com.usdj.java.escape.abstract_interface;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * <h1>Java8新增的静态方法和默认方法</h1>
 *
 * @author <a href="jaredtang93@gmail.com">JaredTang</a>
 * @since 1.8
 */
public class Main {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
		int min = list.stream().min(Comparator.comparing(value -> value)).get();
		int max = list.stream().max(Comparator.comparing(value -> value)).get();
		System.out.println(min);
		System.out.println(max);
		IBaseWorking.time();
		IExtraWorking.time();
	}
}
