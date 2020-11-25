package com.usdj.java.escape;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>不要使用原始类型</h1>
 *
 * @author <a href="jaredtang93@gmail.com">JaredTang</a>
 * @since 1.8
 */
@SuppressWarnings("all")
public class DoNotUseRawType {

	/**
	 * <h2>简单使用原始类型</h2>
	 * @param args
	 */
	private static void simpleExample() {
		List data = new ArrayList();
		data.add("jared");
		data.add(19);
		data.add("hello world!");
//		data.forEach(System.out ::println);

		// 这里会报类型转化的异常，使用原始类型的一个坑
//		data.forEach(d -> {
//			if (((String) d).equals("hello world!")) {
//				System.out.println(data.indexOf(d));
//			}
//		});
		// 通过类型判断为string再自行equals，这样虽然不报错，但是代码可读性非常差
//		data.forEach(d -> {
//			if ( d instanceof String && ((String) d).equals("hello world!")){
//				System.out.println(data.indexOf(d));
//			}
//		});
	}

	/**
	 * <h2>优化使用原始类型</h2>
	 */
	private static void optimizeUsage() {
//		List<Object> data = new ArrayList<>();
//		data.add("jared");
//		data.add(19);
//		data.add("hello world!");
//		data.forEach(System.out::println);
		// java为什么没有强制需要指明元素类型，为了版本兼容
		List<People> data = new ArrayList<>();
	}

	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	private static class People {
		private String name;
		private Integer age;
		private String signature;
	}

	public static void main(String[] args) {
//		List<String> list = null;
		// 这种没有指定元素类型的，为原始类型，虽然java中是允许的，但是不推荐
//		List list = null;
		simpleExample();
	}

}
