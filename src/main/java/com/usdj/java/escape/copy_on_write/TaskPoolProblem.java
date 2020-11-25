package com.usdj.java.escape.copy_on_write;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>并发读写会抛出异常</h1>
 *
 * @author <a href="jaredtang93@gmail.com">JaredTang</a>
 * @since 1.8
 */
public class TaskPoolProblem {
	private static final List<String> tasks = new ArrayList<>();

	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < 10; i++) {
			tasks.add("task-" + i);
		}

		Thread thread = new Thread(() -> {
			while (true) {
				tasks.add("task-x");
			}
		});

		thread.setDaemon(true);
		thread.start();
		Thread.sleep(1000L);

		for (String task : tasks) {
			System.out.println(task);
		}
	}
}
