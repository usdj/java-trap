package com.usdj.java.escape.copy_on_write;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * <h1>商品信息栗子</h1>
 *
 * @author <a href="jaredtang93@gmail.com">JaredTang</a>
 * @since 1.8
 */
@SuppressWarnings("all")
public class GoodListService {

	private static final List<String> goods = new CopyOnWriteArrayList<>();

	public static boolean contains(String good) {
		return goods.contains(good);
	}

	public static void addGood(String good) {
		goods.add(good);
	}

	public static void addGoods(List<String> goods) {
		goods.addAll(goods);
	}
}
