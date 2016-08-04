package com.zdf.beta.tencent.weixin.service;

/**
 * Created by Administrator on 2016/8/3.
 */
public interface PushService {


    /**
     * 授权操作
     *
     * @param params
     * @return
     */
    public String accredit(String params);


    /**
     * 消息推送操作
     *
     * @param params
     * @return
     */
    public String pushMsg(String params);

}
