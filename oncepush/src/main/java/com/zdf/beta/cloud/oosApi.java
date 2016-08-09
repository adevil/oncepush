package com.zdf.beta.cloud;

/**
 * Created by 13764 on 2016/8/9.
 */
public abstract class oosApi implements cloudApi {

    //云服务商密钥
    private String privateKey;

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }


    /**
     * 普通上传
     * @return
     */
    public abstract String upload();


}
