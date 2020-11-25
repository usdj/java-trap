package com.usdj.java.escape.thread_local;

/**
 * TODO
 *
 * @author <a href="jaredtang93@gmail.com">JaredTang</a>
 * @since 1.8
 */
public class DoCompetition {
	public void code() {
		Competition.Material material = Competition.materialThreadLocal.get();
		material.setCode(Thread.currentThread().getName());
		Competition.materialThreadLocal.set(material);
	}

	public void config() {
		Competition.Material material = Competition.materialThreadLocal.get();
		material.setCode(Thread.currentThread().getName());
		Competition.materialThreadLocal.set(material);
	}

	public void print() {
		System.out.println(
				String.format("Thread name: %s,ThreadLocal hashcode: %s, Instance hashcode: %s," +
								"Value: %s",
						Thread.currentThread().getName(),
						Competition.materialThreadLocal.hashCode(),
						Competition.materialThreadLocal.get().hashCode(),
						Competition.materialThreadLocal.get().toString())
		);
	}
}
