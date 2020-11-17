package com.usdj.java.escape;

import java.util.*;

/**
 * <h1>判等于集合存储的问题</h1>
 *
 * @author <a href="jaredtang93@gmail.com">JaredTang</a>
 * @since 1.8
 */
public class EqualOrElse {
	public static class User implements Comparable<User>{
		private String name;
		private Integer age;

		public User(String name, Integer age) {
			this.name = name;
			this.age = age;
		}

		public User() {
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Integer getAge() {
			return age;
		}

		public void setAge(Integer age) {
			this.age = age;
		}

		@Override
		public boolean equals(Object obj) {
			if (obj instanceof User) {
				User user = (User) obj;
				return this.name.equals(user.name) && this.age.equals(user.age);
			}
			return false;
		}

		@Override
		public int hashCode() {
			int result = name.hashCode();
			result = 31 * result + age;
			return result;
		}

		@Override
		public int compareTo(User o) {
			return (this.age - o.age) + this.name.compareTo(o.name);
		}
	}

	/**
	 * <h2>实现/不实现equals方法和hashCode对于判等的影响</h2>
	 */
	private static void equalsAndHashcode() {
		User user1 = new User("jared", 27);
		User user2 = new User("jared", 27);
//		System.out.println(user1.equals(user2));
		//重写了equals方法，似乎user1和user2是相等，同一对象，那么set,map大小为1，其实set，map是通过hashCode来判断是否同一对象
		//重写hasCode后set,map都只存了一个对象，那么大小为1
		HashSet<User> userSet = new HashSet<>();
		userSet.add(user1);
		userSet.add(user2);
		Map<User,Integer> userIntegerMap = new HashMap<>();
		userIntegerMap.put(user1,0);
		userIntegerMap.put(user2,1);
		System.out.println(userSet.size());
		System.out.println(userIntegerMap.size());
	}

	/**
	 * <h2>集合元素索引和equals方法相关</h2>
	 */
	private static void compareToAndEquals() {
		List<User> users = new ArrayList<>();
		users.add(new User("Jared", 20));
		users.add(new User("Jared", 25));
		User user = new User("Jared", 25);
		// indexOf基于equals方法的比较
		int index1 = users.indexOf(user);
		// binarySearch基于compareTo方法比较
		int index2 = Collections.binarySearch(users,user);
		System.out.println(index1);
		System.out.println(index2);
	}

	public static void main(String[] args) {
//		equalsAndHashcode();

		compareToAndEquals();
	}
}
