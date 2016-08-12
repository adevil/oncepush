/**
 * Copyright (c) 2014, www.xinxindai.com All Rights Reserved.
 */
package com.duofa.util.io;

/**
 * 应用IO异常类
 *
 * @since jdk1.6
 * @version $Id: IOUtilException.java 3279 2014-08-06 03:38:42Z xiaoying $
 */
public class IOUtilException extends RuntimeException {
    /**
     * @param reason
     */
    public IOUtilException(String reason) {
        super(reason);
    }

    /**
     * @param cause
     */
    public IOUtilException(Throwable cause) {
        super(cause);
    }

}
