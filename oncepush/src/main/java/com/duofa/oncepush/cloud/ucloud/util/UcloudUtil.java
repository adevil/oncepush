package com.duofa.oncepush.cloud.ucloud.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;


/**
 * Created by 13764 on 2016/8/10.
 */
public class UcloudUtil {

    private static Logger LOGGER = LoggerFactory.getLogger(UcloudUtil.class);


    /**
     * 获取ucloud的签名(全网站签名方式统一)
     * @param url
     * @param params
     * @param encoding
     * @param privateKey
     * @return
     * @throws UnsupportedEncodingException
     * @throws URISyntaxException
     */
//    @Deprecated
//    public static String getSignature(String url, Map<String, String> params, String encoding, String privateKey)
//            throws UnsupportedEncodingException, URISyntaxException {
//
//        //判断参数是否正确
//        if (params == null || params.size() == 0) {
//            LOGGER.error("get signature error : params is null :{params:{url:{},params:{},encoding:{},privateKey:secret}",
//                    url,JsonUtil.beanToJson(params),encoding);
//            throw new CloudApiCallException();
//        }
//
//
//        //对请求参数进行URL编码
//        for (Map.Entry<String, String> entry : params.entrySet()) {
//            params.put(entry.getKey(), URLEncoder.encode(entry.getValue(), encoding));
//        }
//
//        List<Map.Entry<String, String>> sortList = new ArrayList<Map.Entry<String, String>>(params.entrySet());
//
//        //将请求参数按照名进行升序排列
//        Collections.sort(sortList, new Comparator<Map.Entry<String, String>>() {
//            public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
//                Map.Entry obj1 = (Map.Entry) o1;
//                Map.Entry obj2 = (Map.Entry) o2;
//                return (obj1.getKey()).toString().compareTo(obj2.getKey().toString());
//            }
//        });
//
//        //生成http请求以及签名字符串
//        URIBuilder uriBuilder = new URIBuilder(url);
//        for (Map.Entry<String, String> entry : sortList) {
//            uriBuilder.setParameter(entry.getKey(), entry.getValue());
//        }
//        String linkUrl = uriBuilder.build().toString() + privateKey;
//        return DigestUtils.sha1Hex(linkUrl);
//    }
}