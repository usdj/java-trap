package com.usdj.java.escape;

import java.util.ArrayList;

/**
 * <h1>字符串、数组、集合在使用时出现空指针</h1>
 *
 * @author <a href="jaredtang93@gmail.com">JaredTang</a>
 * @since 1.8
 */
@SuppressWarnings("all")
public class BasicUsageNpe {

	private static boolean stringEquals(String x, String y ){
		return x.equals(y);
	}

	public static class User {
		private String name;
	}

	public static void main(String[] args) {
		//1.字符串使用equals可能会报空指针错误
//		System.out.println(stringEquals("xyz", null));
//		System.out.println(stringEquals(null, "xyz"));

		//2.对象数组new出来，但是元素没有初始化
//		User[] users = new User[10];
//		for (int i = 0; i < 10; i++) {
			//若没有对数组中对象进行初始化，后续对数组中的对象属性进行赋值自然会报Npe
//			users[i] = new User();
//			users[i].name = "java-" + i;
//		}

		//3.List对象allAll传递null会抛出空指针
//		ArrayList<User> users = new ArrayList<User>();
//		User user = null;
//		ArrayList<User> users_ = null;
//		users.add(user);
		//allAll方法会将传入的collection,先进行toArray，null无属性方法toArray报Npe
//		users.addAll(users_);
	}

}
