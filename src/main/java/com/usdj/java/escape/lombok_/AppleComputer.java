package com.usdj.java.escape.lombok_;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.naming.Name;

/**
 * 当需要比较比较父类的属性时，需要加上@EqualsAndHashCode,默认callSuper为false
 *
 * @author <a href="jaredtang93@gmail.com">JaredTang</a>
 * @since 1.8
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppleComputer extends Computer{
	private long price;
	private String color;

	public AppleComputer(Integer id, String name, long price, String color) {
		super(id, name);
		this.price = price;
		this.color = color;
	}
}
