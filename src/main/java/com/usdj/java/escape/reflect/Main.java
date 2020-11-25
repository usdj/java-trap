package com.usdj.java.escape.reflect;

import java.lang.reflect.Method;

/**
 * <h1>Java中的反射机制</h1>
 *
 * @author <a href="jaredtang93@gmail.com">JaredTang</a>
 * @since 1.8
 */
public class Main {

	/**
	 * <h2>方法的参数是基本类型、反射获取Method参数类型必须一致</h2>
	 * @throws Exception
	 */
	private static void reflectDeclareMethod() throws Exception {
		Class<Boss> clz = Boss.class;
		Method[] methods = clz.getDeclaredMethods();
		// boss的nueric方法参数是int类型，那么反射获取的方法也必须相同的int类型，使用int包装类型会找不到方法，使用Integer.type也可以找到
		Method method = clz.getDeclaredMethod("numeric", int.class);
//		Method method = clz.getDeclaredMethod("numeric", Integer.class);
		System.out.println(method.invoke(clz.newInstance(),19));
	}

	/**
	 * <h2>调用的方法属于对象的父类，getDeclareMethod会抛出异常</h2>
	 * @throws Exception
	 */
	private static void reflectAcquireClassMethod() throws Exception  {
		Class<Boss> clz = Boss.class;
//		Method method = clz.getMethod("boss", String.class);
//		Method method = clz.getMethod("work", String.class);
//		System.out.println(method.invoke(clz.newInstance(),"boss"));

		// 使用自定义的获取方法
		// 先是不能在子类获取到worker方法，然后再到父类中获取worker方法
		Method superMethod = getMethod(clz, "worker", new Class[]{String.class});
		if (superMethod != null) {
			System.out.println(superMethod.invoke(clz.newInstance(),"boss"));
		}
	}

	private static Method getMethod(Class<?> target, String methodName,
	                                Class<?>[] argTypes) {
		Method method = null;
		try {
			method = target.getDeclaredMethod(methodName,argTypes);
			method.setAccessible(true);
		} catch (NoSuchMethodException e) {
			System.out.println("can not get method:" + methodName + "from" + target.getName());
		}
		if (method == null && target != Object.class) {
			return getMethod(target.getSuperclass(),methodName,argTypes);
		}
		return method;
	}
	public static void main(String[] args) throws Exception {
//		reflectDeclareMethod();
		reflectAcquireClassMethod();
	}
}
