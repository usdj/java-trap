package com.usdj.java.escape.serialization;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * <h1>类中存在引用对象</h1>
 *
 * @author <a href="jaredtang93@gmail.com">JaredTang</a>
 * @since 1.8
 */
@Getter
@Setter
@ToString
public class Combo implements Serializable {

	private int id;
	private People people;

	public Combo(int id, People people) {
		this.id = id;
		this.people = people;
	}
}
