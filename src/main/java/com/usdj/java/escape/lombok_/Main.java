package com.usdj.java.escape.lombok_;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * <h1>lombok工具的使用以及坑</h1>
 *
 * @author <a href="jaredtang93@gmail.com">JaredTang</a>
 * @since 1.8
 */
public class Main {
	/**
	 * <h1>lombok第一个坑</h1>
	 * @throws Exception
	 */
	private static void singleAlphabetHump() throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		Personal personal = new Personal();
		// lombok中对于单字母驼峰的属性进行序列化或者反序列化会存在丢失或者无法解析的问题，应该在编码上避免单字母驼峰的属性命名
//		personal.setIPhone("8.1");
//		System.out.println(mapper.writeValueAsString(personal));
		String json = "{\"name\":\"jared\",\"userName\":\"jaredtang\",\"iPhone\":\"8.1\"}";
		Personal personal1 = mapper.readValue(json, Personal.class);
		System.out.println(personal1);
	}

	/**
	 * <h2>lombok第二个坑</h2>
	 */
	private static void equalsAndHashCodeBug() {
		AppleComputer computer1 = new AppleComputer(1, "Macbook Pro", 10000L,"white");
		AppleComputer computer2 = new AppleComputer(2, "Macbook Air", 10000L,"white");
		System.out.println(computer1.equals(computer2));

	}

	public static void main(String[] args) throws Exception {
//		singleAlphabetHump();
		equalsAndHashCodeBug();
	}
}
