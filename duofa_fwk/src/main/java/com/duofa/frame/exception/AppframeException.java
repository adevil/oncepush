package com.duofa.frame.exception;

/**
 * Created by 13764 on 2016/8/10.
 */
public class AppframeException extends RuntimeException {

    //错误编码
    private String code;


    public AppframeException(){
        super();
    }

    public AppframeException(String code) {
        this.code = code;
    }

    public AppframeException(String message, String code) {
        super(message);
        this.code = code;
    }

    public AppframeException(String message, Throwable cause, String code) {
        super(message, cause);
        this.code = code;
    }

    public AppframeException(Throwable cause, String code) {
        super(cause);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


}
