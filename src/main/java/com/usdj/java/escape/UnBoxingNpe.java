package com.usdj.java.escape;

/**
 * <1>自动拆箱引发的空指针问题</1>
 *
 * @author <a href="jaredtang93@gmail.com">JaredTang</a>
 * @since 1.8
 */
@SuppressWarnings("all")
public class UnBoxingNpe {
	private static int add(int x, int y){
		return x + y;
	}

	private static boolean compare(long x , long y ){
		return x >= y;
	}

	public static void main(String[] args) {

		//1.变量赋值自动拆箱出现的空指针
		// 编译后分析：
		// 1.1javac UnboingNpe.java
		// 1.2javap -c UnboingNpe.class
//		Long count = null;
//		long count_ = count;

		//2.方法传参时自动拆箱引发的空指针
//		Integer left = null;
//		Integer right = null;
//		System.out.println(add(left,right));

		//3.用于大小比较的场景
//		Long left = 10L;
//		Long right = null;
//		System.out.println(compare(left, right));
	}
}
