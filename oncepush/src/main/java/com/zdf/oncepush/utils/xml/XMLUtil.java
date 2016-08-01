/**
 * Copyright (c) 2014, www.xinxindai.com All Rights Reserved.
 */
package com.zdf.oncepush.utils.xml;




import com.zdf.oncepush.utils.lang.StringUtil;
import org.apache.commons.lang3.StringEscapeUtils;

/**
 * XML工具类
 *
 * @since jdk1.6
 * @version $Id: XMLUtil.java 3279 2014-08-06 03:38:42Z xiaoying $
 */
public class XMLUtil {
	/**
	 * 替换字符串中特殊字符
	 */
	public static String encodeString(String str) {
		if (StringUtil.isEmpty(str)) {
			return "";
		}
        return StringEscapeUtils.escapeXml11(str);
	}

	/**
	 * 还原字符串中特殊字符
	 */
	public static String decodeString(String str) {
        return StringEscapeUtils.unescapeXml(str);
	}

}
