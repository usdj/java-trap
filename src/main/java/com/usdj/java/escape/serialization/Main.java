package com.usdj.java.escape.serialization;

import java.io.*;

/**
 * <h1>序列化和反序列化</h1>
 *
 * @author <a href="jaredtang93@gmail.com">JaredTang</a>
 * @since 1.8
 */
@SuppressWarnings("all")
public class Main {

	/**
	 * <h1>序列化和反序列 People对象</h1>
	 * @throws Exception
	 */
	private static void testSerializablePeople() throws Exception {

		// 序列化的步骤
		// 用于存储序列化的文件
		File file = new File("/tmp/people_1.java");
		People people = new People(1L);

		// 创建一个输出流
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(
				new FileOutputStream(file)
		);

		// 输出可序列化对象
		objectOutputStream.writeObject(people);
		// 关闭输出流
		objectOutputStream.close();

		// 反序列化的步骤
		// 创建一个输入流
		ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
		// 得到反序列化的对象
		Object o = objectInputStream.readObject();
		// 关闭输入流
		objectInputStream.close();
		System.out.println(o);

	}

	/**
	 * <h2>子类实现序列化，父类不实现序列化</h2>
	 * @throws Exception
	 */
	private static void testSerializableWorker() throws Exception {
		File file = new File("/tmp/worker_1.java");
		Worker worker = new Worker(1L, "jared", 25);
		// 创建一个输出流
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(
				new FileOutputStream(file)
		);

		// 输出可序列化对象
		objectOutputStream.writeObject(worker);
		// 关闭输出流
		objectOutputStream.close();

		// 反序列化的步骤
		// 创建一个输入流
		ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
		// 得到反序列化的对象
		Object o = objectInputStream.readObject();
		// 关闭输入流
		objectInputStream.close();
		System.out.println(o);

	}

	private static void testSerializableCombo() throws Exception {
		File file = new File("/tmp/combo_1.java");
		Combo  combo = new Combo(1, new People(10L));
		// 创建一个输出流
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(
				new FileOutputStream(file)
		);

		// 输出可序列化对象
		objectOutputStream.writeObject(combo);
		// 关闭输出流
		objectOutputStream.close();

		// 反序列化的步骤
		// 创建一个输入流
		ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
		// 得到反序列化的对象
		Object o = objectInputStream.readObject();
		// 关闭输入流
		objectInputStream.close();
		System.out.println(o);
	}

	/**
	 * <h2>同一对象多次序列化的问题</h2></h2>
	 * @throws Exception
	 */
	private static void sameObjectRepeatedSerialization() throws Exception {
		File file = new File("/tmp/people_more.java");
		People people = new People(10L);
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
		objectOutputStream.writeObject(people);
		objectOutputStream.writeObject(people);
		people.setId(20L);
		objectOutputStream.writeObject(people);
		objectOutputStream.close();

		ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
		Object people1 = objectInputStream.readObject();
		Object people2 = objectInputStream.readObject();
		Object people3 = objectInputStream.readObject();
		objectInputStream.close();
		System.out.println(((People) people1).getId());
		System.out.println(((People) people2).getId());
		System.out.println(((People) people3).getId());

	}
	public static void main(String[] args) throws Exception {
//		testSerializablePeople();
		// 子类实现序列化，父类没实现序列化的话，当父类不可序列化的时候，会调用父类默认无参构造器做初始化
//		testSerializableWorker();
//		testSerializableCombo();
		sameObjectRepeatedSerialization();
	}
}
