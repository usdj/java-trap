package com.usdj.java.escape;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/**
 * <h1>for循环与集合存在的问题</h1>
 *
 * @author <a href="jaredtang93@gmail.com">JaredTang</a>
 * @since 1.8
 */
@SuppressWarnings("all")
public class ForeachOptimize {
	private static Collection<Integer> left =
			Arrays.asList(1,2,3,4,5,6,7,8);
	private static Collection<Integer> right =
			Arrays.asList(1,2,3,4,5);

	/**
	 * <h2>集合迭代经常犯的错误</h2>
	 */
	private static void wrongIterator() {
		// 传统方式 -- 使用索引
		int[] xyz = new int[] {1,2,3,4,5};
		for (int i = 0; i != xyz.length; i++) {
			System.out.println(xyz[i]);
		}
		// 传统方式 -- 迭代器
		for (Iterator<Integer> integerIterator = left.iterator();integerIterator.hasNext();) {
			System.out.println(integerIterator.next());

		}
		// 嵌套迭代容易出现问题，这是错误的嵌套迭代，left的next在内部循环中过早耗尽了
		for (Iterator<Integer> l = left.iterator(); l.hasNext();) {
			for (Iterator<Integer> r = right.iterator(); r.hasNext();){
				System.out.println(l.next() * r.next());
			}
		}

		// 正确的嵌套迭代
		// 传统for循环中索引变量有时候是多余的存在
		for (Iterator<Integer> l = left.iterator(); l.hasNext();) {
			Integer tmp = l.next();
			for (Iterator<Integer> r = right.iterator(); r.hasNext();) System.out.println(tmp * r.next());
		}
	}

	/**
	 * for each的使用
	 */
	public static void forEachIterator() {
		for (Integer l : left) {
			for (Integer r : right) {
				System.out.println(l * r);
			}
		}
	}

	/**
	 * 数平方方法
	 * @param value
	 */
	private static void square(int value) {
		System.out.println( value * value);
	}

	public static void main(String[] args) {
//		wrongIterator();

		// Java8 Iterable.forEach vs for-each
		// Iterable.forEach
		left.forEach(l -> square(l));
		//for-each
		for (Integer l : left) {
			square(l);
		}
		//符号引用,适用于静态方法
		left.forEach(ForeachOptimize::square);
	}
}
