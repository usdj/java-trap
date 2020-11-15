package com.usdj.java.escape;

import com.google.common.base.Enums;

import java.util.*;

/**
 * <h1>编码中的常见的异常</h1>
 *
 * @author <a href="jaredtang93@gmail.com">JaredTang</a>
 * @since 1.8
 */
@SuppressWarnings("all")
public class GeneralException {
	public static class User {
		private String name;

		public User() {
		}

		public String getName() {
			return name;
		}

		public User(String name) {
			this.name = name;
		}
	}

	public static class Manager extends User{}

	public static class Worker extends User{}

	private static void concurrentModificationExcption(ArrayList<User> users){
		// 直接使用for循环会触发并发修改异常
//		for (User user : users) {
//			if (user.getName().equals("learner")) {
//				users.remove(user);
//			}
//		}
		// 使用迭代器则没有问题,更好是通过stream中filter去实现
		Iterator<User> iterator = users.iterator();
		while (iterator.hasNext()){
			User user = iterator.next();
			if (user.getName().equals("java")){
				iterator.remove();
			}
		}
	}

	//
	private static final Map<String,StaffType> typeIndex = new HashMap<>(
			StaffType.values().length
	);

	static {
		for (StaffType value : StaffType.values()) {
			typeIndex.put(value.name(),value);
		}
	}

	private static StaffType enumFind(String type) {
		//原始错误方法
//		return StaffType.valueOf(type);

		//1.最普通，最简单的实现
//		try {
//			return StaffType.valueOf(type);
//		} catch (IllegalArgumentException ex) {
//			return null;
//		}

		//2.改进的实现,但存在过多时，效率不高
//		for (StaffType value : StaffType.values()) {
//			if (value.name().equals(type)) {
//				return value;
//			}
//		}
//		return null;

		//3.静态map索引，只有一次循环枚举的过程
//		return typeIndex.get(type);
		//4.使用Google Guava Enums,需要相关的依赖
		return Enums.getIfPresent(StaffType.class,type).orNull();
	}

	public static void main(String[] args) {
		// 1.并发修改异常
//		ArrayList<User> users = new ArrayList<>(
//				Arrays.asList(new User("hello"),
//						new User("java"),
//						new User("learner"))
//		);
//		concurrentModificationExcption(users);

		// 2.类型转换异常
//		User user1 = new Manager();
//		User user2 = new Worker();

//		Manager m1 = (Manager) user1;
//		Manager m2 = (Manager) user2;

//		System.out.println(user2.getClass().getName());
//		System.out.println(user2 instanceof Manager);

		// 3.枚举查找异常
		System.out.println(enumFind("RD"));
		System.out.println(enumFind("test"));

	}


}
