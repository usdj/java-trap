package com.usdj.java.escape.abstract_interface;

/**
 * <h1>员工类</h1>
 *
 * @author <a href="jaredtang93@gmail.com">JaredTang</a>
 * @since 1.8
 */
// 两个接口定义相同的名称的默认方法会有语法错误,解决方法1.两个接口不同的默认方法；2.实现类中重写默认方法
public class Worker extends BaseWorker implements IBaseWorking,IExtraWorking {
	@Override
	protected void clockIn() {

	}

	@Override
	protected void clockOut() {

	}

	@Override
	public void baseCoding() {

	}

	@Override
	public void baseTesting() {

	}

	@Override
	public void extraCoding() {

	}

	@Override
	public void extraTesting() {

	}
}
