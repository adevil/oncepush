package com.zdf.beta.utils.http;


import com.zdf.beta.utils.json.JsonUtil;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Created by Administrator on 2016/8/3.
 */
public class HttpClientUtil {

    private static Logger LOGGER = LoggerFactory.getLogger(HttpClientUtil.class);

    /**
     * httpclient get请求
     *
     * @param url
     * @param encoding
     * @return
     */
    public static String doGet(String url, String encoding) throws IOException {
        LOGGER.info("do get request : [params:{url:{},encoding:{}}]", url, encoding);

        String jsonStr = null;
        HttpGet httpget = null;
        CloseableHttpResponse response = null;
        HttpEntity entity = null;

        try {
            //创建httpclient对象
            CloseableHttpClient httpclient = HttpClients.createDefault();
            //创建get方式请求对象
            httpget = new HttpGet(url);

            //配置请求的超时设置
            RequestConfig requestConfig = RequestConfig.custom()
                    .setConnectionRequestTimeout(10000)
                    .setConnectTimeout(10000)
                    .setSocketTimeout(10000).build();
            httpget.setConfig(requestConfig);

            //设置请求头
            httpget.setHeader("Content-type", "application/x-www-form-urlencoded");
            httpget.setHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");


            //执行请求操作，并拿到结果（同步阻塞）
            response = httpclient.execute(httpget);

            //获取结果实体
            entity = response.getEntity();
            if (entity != null) {
                //按指定编码转换结果实体为String类型
                jsonStr = EntityUtils.toString(entity, encoding);
                LOGGER.debug("call {} ; response body: {}", url, jsonStr);
            }
        } finally {
            closeHttpClientResource(entity, httpget, response);
        }

        return jsonStr;
    }


    /**
     * 关闭资源
     *
     * @param httpEntity
     * @param httpGet
     * @param response
     */
    private static void closeHttpClientResource(HttpEntity httpEntity, HttpGet httpGet, CloseableHttpResponse response) {
        //如果返回的是流，关闭 (源码中有判空，以及判断)
        try {
            EntityUtils.consume(httpEntity);
        } catch (Exception e) {
            LOGGER.warn("close http client resource error : consume HttpEntity failed : [params:{httpEntity:{}},httpGet:{},response:{}]",
                    JsonUtil.beanToJson(httpEntity), JsonUtil.beanToJson(httpGet), JsonUtil.beanToJson(response), e);
        }

        //释放链接
        try {
            if (response != null) {
                response.close();
            }
        } catch (Exception e) {
            LOGGER.warn("close http client resource error : close response  failed : [params:{httpEntity:{}},httpGet:{},response:{}]",
                    JsonUtil.beanToJson(httpEntity), JsonUtil.beanToJson(httpGet), JsonUtil.beanToJson(response), e);
        }
        //释放连接
        try {
            if (httpGet != null) {
                httpGet.releaseConnection();
            }
        } catch (Exception e) {
            LOGGER.warn("close http client resource error : httpGet release connection failed : [params:{httpEntity:{}},httpGet:{},response:{}]",
                    JsonUtil.beanToJson(httpEntity), JsonUtil.beanToJson(httpGet), JsonUtil.beanToJson(response), e);
        }
    }




}
