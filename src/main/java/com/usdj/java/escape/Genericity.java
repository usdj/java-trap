package com.usdj.java.escape;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>理解泛型</h1>
 *
 * @author <a href="jaredtang93@gmail.com">JaredTang</a>
 * @since 1.8
 */
@SuppressWarnings("all")
public class Genericity {

	/**
	 * <h2>简单实用泛型</h2>
	 */
	private static void easyUsage() throws Exception {
		// 编译器会进行类型擦除，所以会得到两者都是ArrayList，并不知道String还是Integer
		List<String> left = new ArrayList<>();
		List<Integer> right = new ArrayList<>();

//		System.out.println(left.getClass());
//		System.out.println(left.getClass() == right.getClass());

		// 擦除了类型，所以不能进行类型判断，报错
//		if (left instanceof ArrayList<Integer>){}
		// 只能这两者判断
//		if (left instanceof ArrayList) {}
//		if (left instanceof ArrayList<?>) {}

		// 创建Integer类型的List,只能添加整形，但是通过反射能进行运行时添加字符串，浮点等
		// 输出结果为1  abcd 1.2 并没有报错
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.getClass().getMethod("add",Object.class).invoke(list,"abcd");
		list.getClass().getMethod("add",Object.class).invoke(list,1.2);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

	/**
	 * <h2>泛型是先检查再编译</h2>
	 */
	private static void checkAndCompile() {
		ArrayList<String> list = new ArrayList<>();
		list.add("1234");
		// 先检查类型，符合在进行编译，但编译后其实类型都是object
//		list.add(123);
	}

	/**
	 * <h2>泛型不支持继承</h2>
	 */
	private static void genericityCanNotExtend() {

		// 第一类错误
//		ArrayList<String> first = new ArrayList<Object>();
		// 上下其实是等同的
//		ArrayList<Object> list1 = new ArrayList<>();
//		list1.add(new Object());
//		ArrayList<String> list2 = list1;

		// 第二类错误
//		ArrayList<Object> second = new ArrayList<String>();
		// 上下是等同的
		// string向上是应该可以转object的，但是泛型设计的目的是除去类型转换的问题，因此编译器也是拒绝泛型中这样的编码
//		ArrayList<String> list1  = new ArrayList<>();
//		list1.add(new String());
//		ArrayList<Object> list2 = list1;
	}

	/**
	 * <h2>泛型的类型变量不能是基本数据类型</h2>
	 */
	private static void baseTypeCanNotUseGenericity() {
		// 这是因为类型擦除后是object类型，不能存储int基本类型，因此只能使用包装类型
//		List<int> invaild = new ArrayList<>();
	}

	/**
	 * <h2>泛型的类型参数只能是类类型，不能是简单类型</h2>
	 * @param values
	 * @param <T>
	 */
	private static <T> void doSomething(T... values) {
		for (T value : values) {
			System.out.println(value);
		}
	}

	public static void main(String[] args) throws Exception{
//		easyUsage();

		Integer[] ints1 = {1, 2, 3};
		// 传入简单类型，把简单类型的地址当做类类型传递进去，即只输出一个地址了
		int[] ints2 = {1, 2, 3};
		// 可以正确输出  1 2 3
		doSomething(ints1);
		// 输出的是一个地址
		doSomething(ints2);
	}
}
