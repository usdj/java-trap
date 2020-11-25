package com.usdj.java.escape.thread_local;

/**
 * <h1>ThreadLocal的使用和对它的理解</h1>
 *
 * @author <a href="jaredtang93@gmail.com">JaredTang</a>
 * @since 1.8
 */
public class Main {
	/**
	 * <h2>ThreadLocal不支持继承</h2>
	 */
	private static void threadLocalCanNotInherit(){
		ThreadLocal<String> name = new ThreadLocal<>();
		name.set("jared01");

		Thread sub = new Thread(() -> System.out.println("Name In Sub:" + name.get()));
		sub.start();

		System.out.println("Name In Main: " + name.get());
	}
	public static void main(String[] args) {
//		for (int i = 0; i < 3; i++) {
//			new Thread(
//					() -> {
//						DoCompetition competition = new DoCompetition();
//						competition.code();
//						competition.config();
//						competition.print();
//					},"thread--" + (i+1)
//			).start();
//		}

		threadLocalCanNotInherit();
	}
}
