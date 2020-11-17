package com.usdj.java.escape.abstract_interface;

/**
 * <h1>每一个worker最基本的属性</h1>
 *
 * @author <a href="jaredtang93@gmail.com">JaredTang</a>
 * @since 1.8
 */
public abstract class BaseWorker {

	/** 起床时间 */
	protected int wakeupTime = 8;

	/** 上班打卡 */
	protected abstract void clockIn();

	/** 下班打卡 */
	protected abstract void clockOut();
}
