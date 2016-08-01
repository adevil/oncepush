/**
 * Copyright (c) 2014, www.xinxindai.com All Rights Reserved. 
 *
 */
package com.zdf.oncepush.utils.config;

import java.util.ResourceBundle;

/**
 * 描述
 *
 * @version $Id: Config.java 9464 2014-11-07 12:23:02Z xiaoying $
 * @since jdk1.6
 */
public class Config {
    private ResourceBundle rb;

    private Config(){

    }

    public Config(String cfgFile) {
        rb = ResourceBundle.getBundle(cfgFile);
    }

    public String getValue(String key) {
        return (rb.getString(key));
    }
}
