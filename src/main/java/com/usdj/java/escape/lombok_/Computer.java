package com.usdj.java.escape.lombok_;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * TODO
 *
 * @author <a href="jaredtang93@gmail.com">JaredTang</a>
 * @since 1.8
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Computer {
	private Integer id;
	private String name;
}
