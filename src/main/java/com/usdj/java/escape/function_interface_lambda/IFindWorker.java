package com.usdj.java.escape.function_interface_lambda;

/**
 * <h1>函数式接口</h1>
 *
 * @author <a href="jaredtang93@gmail.com">JaredTang</a>
 * @since 1.8
 */
@FunctionalInterface
public interface IFindWorker {

	Worker findWorkerById(Long id);
}
