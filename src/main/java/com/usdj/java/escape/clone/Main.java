package com.usdj.java.escape.clone;

/**
 * <h1>理解深拷贝和浅拷贝</h1>
 *
 * @author <a href="jaredtang93@gmail.com">JaredTang</a>
 * @since 1.8
 */
@SuppressWarnings("all")
public class Main {

	/**
	 * 类不实现Cloneable接口，调用object的clone会抛异常
	 * @throws CloneNotSupportedException
	 */
	private static void canNotClone() throws CloneNotSupportedException {
		Main main = new Main();
		Object clone = main.clone();
	}

	/**
	 * 验证了object clone是浅拷贝,对引用对象是浅拷贝
	 * @throws CloneNotSupportedException
	 */
	private static void copyTest() throws CloneNotSupportedException {
		Worker worker1 = new Worker("jared", 25,"m","EDU" ,"2000" );
		System.out.println("原始对象:" + worker1.getEducationInfo().getSchool() + worker1.getName());
		Worker worker2 = (Worker)worker1.clone();
		System.out.println("拷贝对象:" + worker2.getEducationInfo().getSchool() + worker1.getName());
		worker2.getEducationInfo().setSchool("EDU123");
		worker2.setName("hello");
		System.out.println("修改后原始对象:" + worker1.getEducationInfo().getSchool() + worker1.getName());
		System.out.println("修改后拷贝对象:" + worker2.getEducationInfo().getSchool() + worker2.getName());
	}

	public static void main(String[] args) throws CloneNotSupportedException {
//		canNotClone();
		copyTest();
	}
}
