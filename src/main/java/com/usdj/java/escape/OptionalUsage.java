package com.usdj.java.escape;

import java.util.Optional;

/**
 * <h1>Optional基本使用</h1>
 *
 * @author <a href="jaredtang93@gmail.com">JaredTang</a>
 * @since 1.8
 */
@SuppressWarnings("all")
public class OptionalUsage {

	public static class User {
		private String name;

		public String getName() {
			return name;
		}
	}

	private static void isUserEqualNull() {
		//不使用optional方式
		User user = null;
		if (user != null) {
			System.out.println("User is not null");
		} else {
			System.out.println("User is null");
		}
		//使用optional方式
		Optional<User> optional = Optional.empty();
		if (optional.isPresent()) {
			System.out.println("User is not null");
		} else {
			System.out.println("User is null");
		}
	}

	private static User anoymos() {
		return new User();
	}

	public static void main(String[] args) {
		//没有意义的使用方法
		isUserEqualNull();

		User user = null;
		Optional<User> optionalUser = Optional.ofNullable(user);
		//orElse存在即返回，空则提供默认值
		optionalUser.orElse(new User());
		//orElseGet存在即返回，空则由函数去产生
		optionalUser.orElseGet(() -> anoymos());
		//orElseThrow存在即返回，否则抛出异常
		optionalUser.orElseThrow(RuntimeException::new);
		//存在才去做相应的处理
		optionalUser.ifPresent(u -> System.out.println(u.getName()));
		//map可以对Optional中的对象执行某种操作，且会返回一个Optional对象
		optionalUser.map(u -> u.getName()).orElse("anymos");
		//map是可以无限级联操作
		optionalUser.map(u -> u.getName()).map(name -> name.length()).orElse(0);
	}
}
