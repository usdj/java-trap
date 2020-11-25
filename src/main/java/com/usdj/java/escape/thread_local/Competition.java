package com.usdj.java.escape.thread_local;

/**
 * <h1>模拟比赛类</h1>
 *
 * @author <a href="jaredtang93@gmail.com">JaredTang</a>
 * @since 1.8
 */
public class Competition {

	public static ThreadLocal<Material> materialThreadLocal = ThreadLocal.withInitial(
			() -> new Material("InitCode", "InitConfig")
	);

	public static class Material {
		private String code;
		private String config;

		public Material(String code, String config) {
			this.code = code;
			this.config = config;
		}

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public String getConfig() {
			return config;
		}

		public void setConfig(String config) {
			this.config = config;
		}
	}

}
