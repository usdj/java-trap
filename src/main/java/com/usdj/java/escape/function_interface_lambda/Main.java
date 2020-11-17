package com.usdj.java.escape.function_interface_lambda;

import java.util.HashMap;
import java.util.Map;

/**
 * <h1>函数式接口的使用</h1>
 *
 * @author <a href="jaredtang93@gmail.com">JaredTang</a>
 * @since 1.8
 */
@SuppressWarnings("all")
public class Main {

	private static final Map<Long, Worker> id2WorkerMap = new HashMap<>();

	static {
		id2WorkerMap.put(1L, new Worker(1L, "jared", 25));
	}

	public static void main(String[] args) {
		// 两者等同
//		IFindWorker findWorker = id -> id2WorkerMap.get(id);
		IFindWorker findWorker = id2WorkerMap::get;
		System.out.println(findWorker.findWorkerById(1L));
	}
}
