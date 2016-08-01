/**
 * Copyright (c) 2014, www.xinxindai.com All Rights Reserved.
 */
package com.zdf.oncepush.utils.lang;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * 字符串工具类
 *
 * @version $Id: StringUtil.java 9686 2014-11-11 09:37:44Z zhouhuarong $
 * @since jdk1.6
 */
public class StringUtil {

    /**
     * 使用分隔符拼接字符串数组
     *
     * @param strs      字符串数组
     * @param separator 分隔符
     */
    public static String concatStr(String[] strs, String separator) {
        return StringUtils.join(strs, separator);
    }

    /**
     * 将字符串分割为字符串数组
     *
     * @param str       字符串
     * @param separator 分隔符
     */
    public static String[] split(String str, String separator) {
        return StringUtils.split(str, separator);
    }

    /**
     * 整数数组转换成字符串
     *
     * @param nums      整数数组
     * @param separator 分隔符
     */
    public static String intArrayToStr(int[] nums, String separator) {
        return StringUtils.join(nums, separator);
    }

    /**
     * 判断是否为空字符串，空格为空
     */
    public static boolean isBlank(final CharSequence cs) {
        return StringUtils.isBlank(cs);
    }

    /**
     * 判断是否为空字符串，空格不为空
     */
    public static boolean isEmpty(final CharSequence cs) {
        return StringUtils.isEmpty(cs);
    }

    /**
     * 判断是否非空字符串，空格为空
     */
    public static boolean isNotBlank(final CharSequence cs) {
        return StringUtils.isNotBlank(cs);
    }

    /**
     * 判断是否非空字符串，空格不为空
     */
    public static boolean isNotEmpty(final CharSequence cs) {
        return StringUtils.isNotEmpty(cs);
    }

    /**
     * 判断是否为数值
     */
    public static boolean isNumeric(final CharSequence cs) {
        return StringUtils.isNumeric(cs);
    }


    /**
     * 判断是否是自然数
     *
     * @param cs
     * @return
     */
    public static boolean isNaturalNum(final CharSequence cs) {
        Pattern pattern = Pattern.compile("^\\d+$");
        Matcher mc = pattern.matcher(cs);
        return mc.matches();
    }

    /**
     * 生成随机字符
     */
    public static String getRandCode(int length, boolean containChar) {
        if (containChar) {
            return RandomStringUtils.randomAlphanumeric(length);
        } else {
            return RandomStringUtils.randomNumeric(length);
        }
    }
    /**
	 * 使用分隔符拼接字符串数组
	 * 
	 * @param str
	 * @param reg
	 * @return
	 */
	public static String arrayString(String[] str, String reg) {
		if (null == str) {
			return null;
		}
		StringBuffer bf = new StringBuffer();
		for (int i = 0; i < str.length; i++) {
			bf.append(str[i]).append(reg);
		}
		return bf.substring(0, bf.length() - 1);
	}

	/**
	 * 整数数组转换成字符串
	 * 
	 * @param num 整数数组
	 * @param reg 分隔符
	 * @return
	 */
	public static String array2String(int[] num, String reg) {
		if (null == num || num.length < 1) {
			return null;
		}
		StringBuffer bf = new StringBuffer();

		for (int i = 0; i < num.length; i++) {
			bf.append(num[i]).append(reg);
		}

		return bf.substring(0, bf.length() - 1);
	}

	public static Map<String, Double> bigDecimal2Double(
			Map<String, BigDecimal> map) {
		Map<String, Double> mdap = new HashMap<String, Double>();
		Set<String> set = map.keySet();
		for (String str : set) {
			mdap.put(str, map.get(str) == null ? 0 : map.get(str).doubleValue());
		}
		return mdap;
	}
	
	/**
	 * 将字符串进行URL编码，格式为UTF-8,
	 * 
	 * @param str 编码前的字符串
	 * @return URL编码后的字符串
	 */
	public static String encodeUTF8(String str) {
		try {
			if(StringUtil.isNotBlank(str)){
				return URLEncoder.encode(str, "utf-8");
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	/**
	 * 获取字符串
	 * 
	 * @param object 目标对象
	 * @return 目标字符串
	 */
	public static String toString(Object object) {
		if(object != null){
			return object.toString();
		}
		return "";
	}

}
