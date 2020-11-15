package com.usdj.java.escape.try_with_resources;

import java.io.*;

/**
 * <h1>解决使用try finally资源泄露隐患</h1>
 *
 * @author <a href="jaredtang93@gmail.com">JaredTang</a>
 * @since 1.8
 */
public class Main {

	/**
	 * <h2>传统的方式实现对资源的关闭</h2>
	 *
	 * @return
	 * @throws IOException
	 */
	private String traditionTryCatch() throws IOException {
		// 1.单一资源的关闭
//		String line = null;
//		BufferedReader bufferedReader = new BufferedReader(new FileReader(""));
//		try {
//			line = bufferedReader.readLine();
//		} finally {
//			bufferedReader.close();
//		}
//		return line;

		// 2.多个资源的关闭
		// 第一个资源
		InputStream inputStream = new FileInputStream("");
		try {
			// 第二个资源
			OutputStream outputStream = new FileOutputStream("");
			try {
				byte[] buf = new byte[100];
				int n;
				while ((n = inputStream.read(buf)) >= 0) {
					outputStream.write(buf, 0, n);
				}
			} finally {
				outputStream.close();
			}
		} finally {
			inputStream.close();
		}
		return null;
	}

	/**
	 * <h2>java7引入的try with resources 实现自动的资源关闭</h2>
	 *
	 * @return
	 * @throws IOException
	 */
	private String newTryWithResources() throws IOException {
		//1.单个资源的使用与关闭
//		try(BufferedReader bufferedReader = new BufferedReader(new FileReader(""))){
//			return bufferedReader.readLine();
//		}
		//2.多个资源的使用与关闭
		try (FileInputStream inputStream = new FileInputStream("");
		     FileOutputStream outputStream = new FileOutputStream("")) {
			byte[] buffer = new byte[100];
			int n = 0;
			while ((n = inputStream.read()) != -1) {
				outputStream.write(buffer, 0, n);
			}
		}
		return null;

	}

	public static void main(String[] args) throws MyException{
//		AutoClose autoClose = new AutoClose();
		// 传统try finally不能显示work中抛出的异常，直接被close覆盖
//		try {
//			autoClose.work();
//		} finally {
//			autoClose.close();
//		}
//		try(AutoClose autoClose = new AutoClose()){
//			autoClose.work();
//		}
	}
}
