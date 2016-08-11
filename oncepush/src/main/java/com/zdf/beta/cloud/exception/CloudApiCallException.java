package com.zdf.beta.cloud.exception;

import com.zdf.beta.appframe.exception.AppframeException;

/**
 * Created by 13764 on 2016/8/10.
 */
public class CloudApiCallException extends AppframeException{

    public CloudApiCallException() {
        super();
    }

    public CloudApiCallException(String code) {
        super(code);
    }

    public CloudApiCallException(String message, String code) {
        super(message, code);
    }

    public CloudApiCallException(String message, Throwable cause, String code) {
        super(message, cause, code);
    }

    public CloudApiCallException(Throwable cause, String code) {
        super(cause, code);
    }
}
