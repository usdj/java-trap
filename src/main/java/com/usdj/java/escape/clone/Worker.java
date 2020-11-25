package com.usdj.java.escape.clone;

import lombok.Data;

import java.io.*;

/**
 * <h1>员工</h1>
 *
 * @author <a href="jaredtang93@gmail.com">JaredTang</a>
 * @since 1.8
 */
@Data
public class Worker implements /*Cloneable*/ Serializable {

	private String name;
	private Integer age;
	private String gender;

	private EducationInfo educationInfo;

	public Worker(String name, Integer age, String gender, String school, String time) {
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.educationInfo = new EducationInfo(school,time);
	}

	/**
	 * 浅拷贝
	 * @return
	 * @throws CloneNotSupportedException
	 */
//	@Override
//	protected Object clone() throws CloneNotSupportedException {
//		return super.clone();
//	}


//	/**
//	 * 深拷贝
//	 * @return
//	 * @throws CloneNotSupportedException
//	 */
//	@Override
//	protected Object clone() throws CloneNotSupportedException {
		// 第一种方式,低效
//		Worker worker = new Worker(name,age,gender,educationInfo.getSchool(),educationInfo.getTime());
//		return worker;
		// 第二种方式，引用对象也进行clone，也就是引用对象的属性进行clone,但在引用对象多，嵌套多的时候容易出问题
//		try {
//			Worker worker = (Worker) super.clone();
//			worker.educationInfo = (EducationInfo) educationInfo.clone();
//			return worker;
//		} catch (CloneNotSupportedException exception) {
//			return null;
//		}
//	}

	// 第三种方式，推荐使用
	@Override
	public Worker clone() {
		Worker worker = null;
		try {
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
			objectOutputStream.writeObject(this);

			// 将流反序列化成对象
			ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
			ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
			worker = (Worker) objectInputStream.readObject();

		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return worker;
	}
}
