package com.usdj.java.escape.abstract_interface;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * <h1>程序猿的基本工作</h1>
 *
 * @author <a href="jaredtang93@gmail.com">JaredTang</a>
 * @since 1.8
 */
public interface IBaseWorking {
	void baseCoding();

	void baseTesting();

	default void config() {
		System.out.println("BaseWorking For Config");
	}

	static void time() {
		System.out.println(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_TIME));
	}
}