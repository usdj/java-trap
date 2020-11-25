package com.usdj.java.escape.threadpool;

import java.util.Date;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <h1>自定义线程池工厂，带有监控功能</h1>
 *
 * @author <a href="jaredtang93@gmail.com">JaredTang</a>
 * @since 1.8
 */
public class ExecutorsUtil extends ThreadPoolExecutor {

	@Override
	public void shutdown() {
		System.out.println(String.format(this.poolName +
						"Going to shutdown, Executed task: %d," +
						"Running tasks: %d, Pending tasks: %d",
				this.getCompletedTaskCount(),
				this.getActiveCount(),
				this.getQueue().size())
		);
		super.shutdown();
	}

	@Override
	public List<Runnable> shutdownNow() {
		System.out.println(String.format(this.poolName +
						"Going to shutdownNow, Executed task: %d," +
						"Running tasks: %d, Pending tasks: %d",
				this.getCompletedTaskCount(),
				this.getActiveCount(),
				this.getQueue().size())
		);
		return super.shutdownNow();
	}

	@Override
	protected void beforeExecute(Thread t, Runnable r) {
		startTimes.put(String.valueOf(r.hashCode()), new Date());
	}

	@Override
	protected void afterExecute(Runnable r, Throwable t) {
		Date startDate = startTimes.remove(String.valueOf(r.hashCode()));
		Date finishDate = new Date();
		long diff = finishDate.getTime() - startDate.getTime();
		System.out.println(String.format("task running time: %d", diff));
	}

	public static ExecutorService newFixedThreadPool(int nThreads, String poolName) {
		return new ExecutorsUtil(nThreads, nThreads, 0L, TimeUnit.MILLISECONDS,
				new LinkedBlockingQueue<>(), poolName);
	}

	private ConcurrentHashMap<String, Date> startTimes;
	private String poolName;

	public ExecutorsUtil(int corePoolSize, int maximumPoolSize, long keepAliveTime,
	                     TimeUnit unit, BlockingQueue<Runnable> workQueue,
	                     String poolName) {
		super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue,
				new ExecutorsUtil.EventThreadFactory(poolName));
		this.startTimes = new ConcurrentHashMap<>();
		this.poolName = poolName;
	}

	static class EventThreadFactory implements ThreadFactory {

		private static final AtomicInteger poolNumber = new AtomicInteger();
		private final ThreadGroup group;
		private final AtomicInteger threadNumber = new AtomicInteger(1);
		private final String namePrefix;

		public EventThreadFactory(String poolName) {
			SecurityManager securityManager = System.getSecurityManager();
			group = (securityManager != null) ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
			namePrefix = poolName + "-pool-" + poolNumber.getAndIncrement()
					+ " thread";
		}

		@Override
		public Thread newThread(Runnable r) {
			Thread thread = new Thread(
					group, r, namePrefix + threadNumber.getAndIncrement(), 0
			);
			if (thread.isDaemon()) {
				thread.setDaemon(false);
			}
			if (thread.getPriority() != Thread.NORM_PRIORITY) {
				thread.setPriority(Thread.NORM_PRIORITY);
			}
			return thread;
		}
	}
}
