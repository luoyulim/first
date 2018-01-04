package cn.itcast.constant;

/**
 * Copyright (C), 2006-2010, Computer Technology info. Co., Ltd.
 * 
 * 常量
 * 
 * @author Derek Sun
 * @version 1.00
 *
 */
public interface UtilConstants {
	
	/**
	 * 公共常量
	 */
	public static class Common {
		public static final String XXX_YYY_ZZZ = "";
	}
	
	public static class DICT {
		public static final String CUST_SOURCE = "002";
		public static final String CUST_INDUSTRY = "001";
		public static final String CUST_LEVEL = "006";
		
	}
	
	/**
	 * 后台处理结果常量
	 */
	public static class Result {
		public static final String SUCCESS = "0";  // 成功
		public static final String FAILURE = "-1"; // 失败
	}
	
	/**
	 * 页面常量
	 */
	public static class FilePath {
		public static final String IMAGE_PATH = "img/a/b";
	}
	
	/**
	 * vo对象的一些公共的属性名称
	 */
	public static class VoFields {
		public static final String ACTION_TIME = "operateTime";   //操作时间
		public static final String ACTION_USER_NAME = "operatorName";   //操作人姓名
		public static final String CHECK_TIME = "auditTime";   //审核时间
		public static final String CHECK_USER_ID = "checkUserId";   //审核人ID
	}

}
