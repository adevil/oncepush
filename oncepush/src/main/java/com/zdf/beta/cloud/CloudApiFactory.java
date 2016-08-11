package com.zdf.beta.cloud;

/**
 * Created by 13764 on 2016/8/10.
 */
public interface CloudApiFactory {

    /**
     * 获取对象存储服务API
     * @return
     */
    public OOSApi getOOSApi();


    //todo DBAPI
}
