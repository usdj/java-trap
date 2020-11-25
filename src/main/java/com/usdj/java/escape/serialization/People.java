package com.usdj.java.escape.serialization;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * <h1>Java Object</h1>
 *
 * @author <a href="jaredtang93@gmail.com">JaredTang</a>
 * @since 1.8
 */
@Getter
@Setter
@ToString
public class People implements Serializable {

	private Long id;

	public People() {
	}

	public People(Long id) {
		this.id = id;
	}
}
