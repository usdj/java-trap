package com.usdj.java.escape.abstract_interface;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * <h1>部分程序猿的工作</h1>
 *
 * @author <a href="jaredtang93@gmail.com">JaredTang</a>
 * @since 1.8
 */
public interface IExtraWorking {
	void extraCoding();

	void extraTesting();

//	default void config() {
//		System.out.println("ExtraWorking For Config");
//	}
	static void time() {
		System.out.println(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_TIME));
	}
}
