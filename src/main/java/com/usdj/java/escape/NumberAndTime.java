package com.usdj.java.escape;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * <h1>数值计算和时间计算</h1>
 *
 * @author <a href="jaredtang93@gmail.com">JaredTang</a>
 * @since 1.8
 */
@SuppressWarnings("all")
public class NumberAndTime {

	/**
	 * <h2>scale 需要和小数位匹配</h2>
	 */
	private static void scaleProblem(){
		BigDecimal decimal = new BigDecimal("11.1111");
		// 造成精度丢失，会报数学运算异常
//		BigDecimal result = decimal.setScale(3);
//		System.out.println(result);
		// 选择舍去精度精度方式
		BigDecimal result = decimal.setScale(3, RoundingMode.HALF_UP);
		System.out.println(result);
	}

	/**
	 * <h2>BigDecimal做除法时出现除不尽的情况</h2>
	 */
	private static void divideProblem(){
		// 同样报数学运算异常
//		System.out.println(new BigDecimal(30).divide(new BigDecimal(7)));

		System.out.println(new BigDecimal(30).divide(new BigDecimal(7), 3, RoundingMode.HALF_UP));
	}

	/**
	 * <h2>精度问题导致比较结果和预期的不一致</h2>
	 */
	private static void equalProblem(){
		// 字符串比较是false，而大小比较是true
		BigDecimal bd1 = new BigDecimal("0");
		BigDecimal bd2 = new BigDecimal("0.0");
		System.out.println(bd1.equals(bd2));
		System.out.println(bd1.compareTo(bd2)==0);
	}

	/**
	 * <h2>SimpleDateFormat可以解析大于/等于它定义的时间精度</h2>
	 * @throws Exception
	 */
	private static void formatPrecision() throws Exception {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		// time1会抛出parse异常
		String time1 = "2020-11";
		String time2 = "2020-11-16 12:01:20";
		System.out.println(simpleDateFormat.parse(time1));
		System.out.println(simpleDateFormat.parse(time2));
	}

	/**
	 * <h2>SimpleDateFormat存在线程安全问题</h2>
	 * @param args
	 */
	private static void threadSafety() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 100, 1, TimeUnit.MINUTES,
				new LinkedBlockingQueue<>(1000));
		// 多线程会发生线程不安全是因为SimpleDateFormat集成了DateFormat，其中parse和format都方法都存在引用了Calendar对象，引用对象被共享
		while (true) {
			threadPoolExecutor.execute(() -> {
				String time = "2020-11-16 12:01:20";
				try {
					Date parseDate = simpleDateFormat.parse(time);
					String dateString = simpleDateFormat.format(parseDate);
					System.out.println(dateString.equals(time));
				} catch (ParseException ex) {
					ex.printStackTrace();
				}
			});
		}
	}

	public static void main(String[] args) {
//		scaleProblem();
//		divideProblem();
		equalProblem();
//		try {
//			formatPrecision();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		threadSafety();
	}
}
