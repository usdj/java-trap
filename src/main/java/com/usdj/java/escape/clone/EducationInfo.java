package com.usdj.java.escape.clone;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * <h1>教育信息</h1>
 *
 * @author <a href="jaredtang93@gmail.com">JaredTang</a>
 * @since 1.8
 */
@Data
@AllArgsConstructor
public class EducationInfo implements /*Cloneable*/ Serializable {

	private String school;

	private String time;

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
