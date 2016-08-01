/**
 * Copyright (c) 2014, www.xinxindai.com All Rights Reserved. 
 *
 */
package com.zdf.oncepush.utils.lang;

import java.util.regex.Pattern;

/**
 * 校验工具类 邮箱、手机号、身份证号等
 *
 * @version $Id: ValiateUtil.java 9464 2014-11-07 12:23:02Z xiaoying $
 * @since jdk1.6
 */
public class ValiateUtil {
    private static Pattern mailPattern = Pattern.compile("^.+@.+\\.[a-z]+$");
    private static Pattern mpPattern = Pattern.compile("^0?1[0-9]{10}$");
    private static Pattern idCardPattern = Pattern.compile("^(\\d{14}|\\d{17})(\\d|[xX])$");
    private static Pattern ipPattern = Pattern.compile("^([1-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])(\\.([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])){3}$");
    private static Pattern pwPattern = Pattern.compile("^([a-zA-Z0-9])*{6,16}$");

    	
    public static boolean isEmail(String str) {
        if (str == null) {
            return false;
        }
        return mailPattern.matcher(str).matches();
    }

    public static boolean isMp(String str) {
        if (str == null) {
            return false;
        }
        return mpPattern.matcher(str).matches();
    }

    public static boolean isIdCard(String str) {
        if (str == null) {
            return false;
        }
        return idCardPattern.matcher(str).matches();
    }

    public static boolean isIp(String ip) {
        if (ip == null) {
            return false;
        }
        return ipPattern.matcher(ip).matches();
    }
    
    public static boolean isPsw(String psw)
    {
    	  if (psw == null) {
              return false;
          }
    	return pwPattern.matcher(psw).matches();
    }
}
