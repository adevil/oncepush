package com.zdf.beta.utils.http;


import com.zdf.beta.utils.json.JsonUtil;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/8/3.
 */
public class HttpClientUtil {

    private static Logger LOGGER = LoggerFactory.getLogger(HttpClientUtil.class);

    /**
     * httpclient get请求
     *
     * @param url
     * @param params
     * @param encoding
     * @return
     * @throws IOException
     */
    public static String doGet(String url, Map<String, String> params, String encoding) throws IOException, URISyntaxException {
        LOGGER.info("do get request : [params:{url:{},encoding:{}}]", url, encoding);

        String jsonStr = null;
        HttpGet httpGet = null;
        CloseableHttpResponse response = null;
        HttpEntity httpEntity = null;


        try {
            URIBuilder uriBuilder = new URIBuilder(url);
            if (params != null) {
                for (Map.Entry<String, String> entry : params.entrySet()) {
                    uriBuilder.setParameter(entry.getKey(), entry.getValue());
                }
            }
            //创建httpclient对象
            CloseableHttpClient httpclient = HttpClients.createDefault();
            //创建get方式请求对象
            httpGet = new HttpGet(uriBuilder.build());


            //配置请求的超时设置
            RequestConfig requestConfig = RequestConfig.custom()
                    .setConnectionRequestTimeout(10000)
                    .setConnectTimeout(10000)
                    .setSocketTimeout(10000).build();
            httpGet.setConfig(requestConfig);
            LOGGER.debug("URL:{}", httpGet.getURI());


            //设置请求头
            httpGet.setHeader("Content-type", "application/x-www-form-urlencoded");
            httpGet.setHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");


            //执行请求操作，并拿到结果（同步阻塞）
            response = httpclient.execute(httpGet);

            //获取结果实体
            httpEntity = response.getEntity();
            if (httpEntity != null) {
                //按指定编码转换结果实体为String类型
                jsonStr = EntityUtils.toString(httpEntity, encoding);
                LOGGER.debug("call {} ; response body: {}", url, jsonStr);
            }
        } finally {
            closeHttpClientResource(httpEntity, httpGet, response);
        }

        return jsonStr;
    }


    /**
     * httpclient post请求
     *
     * @param url
     * @param params
     * @param encoding
     * @return
     * @throws IOException
     */
    public static String doPost(String url, Map<String, String> params, String encoding) throws IOException, URISyntaxException {
        LOGGER.info("do post request : [params:{url:{},encoding:{}}]", url, encoding);

        String jsonStr = null;
        HttpPost httpPost = null;
        CloseableHttpResponse response = null;
        HttpEntity httpEntity = null;


        try {

            //创建get方式请求对象
            httpPost = new HttpPost(url);

            //装填参数
            List<BasicNameValuePair> nvps = new ArrayList<BasicNameValuePair>();
            if (params != null) {
                for (Map.Entry<String, String> entry : params.entrySet()) {
                    nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
                }
            }
            //设置参数到请求对象中
            httpPost.setEntity(new UrlEncodedFormEntity(nvps, encoding));

            //创建httpclient对象
            CloseableHttpClient httpclient = HttpClients.createDefault();


            //配置请求的超时设置
            RequestConfig requestConfig = RequestConfig.custom()
                    .setConnectionRequestTimeout(10000)
                    .setConnectTimeout(10000)
                    .setSocketTimeout(10000).build();
            httpPost.setConfig(requestConfig);
            LOGGER.debug("URL:{}", httpPost.getURI());


            //设置请求头
            httpPost.setHeader("Content-type", "application/x-www-form-urlencoded");
            httpPost.setHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");


            //执行请求操作，并拿到结果（同步阻塞）
            response = httpclient.execute(httpPost);

            //获取结果实体
            httpEntity = response.getEntity();
            if (httpEntity != null) {
                //按指定编码转换结果实体为String类型
                jsonStr = EntityUtils.toString(httpEntity, encoding);
                LOGGER.debug("call {} ; response body: {}", url, jsonStr);
            }
        } finally {
            closeHttpClientResource(httpEntity, httpPost, response);
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

    /**
     * 关闭资源
     *
     * @param httpEntity
     * @param httpPost
     * @param response
     */
    private static void closeHttpClientResource(HttpEntity httpEntity, HttpPost httpPost, CloseableHttpResponse response) {
        //如果返回的是流，关闭 (源码中有判空，以及判断)
        try {
            EntityUtils.consume(httpEntity);
        } catch (Exception e) {
            LOGGER.warn("close http client resource error : consume HttpEntity failed : [params:{httpEntity:{}},httpGet:{},response:{}]",
                    JsonUtil.beanToJson(httpEntity), JsonUtil.beanToJson(httpPost), JsonUtil.beanToJson(response), e);
        }

        //释放链接
        try {
            if (response != null) {
                response.close();
            }
        } catch (Exception e) {
            LOGGER.warn("close http client resource error : close response  failed : [params:{httpEntity:{}},httpGet:{},response:{}]",
                    JsonUtil.beanToJson(httpEntity), JsonUtil.beanToJson(httpPost), JsonUtil.beanToJson(response), e);
        }
        //释放连接
        try {
            if (httpPost != null) {
                httpPost.releaseConnection();
            }
        } catch (Exception e) {
            LOGGER.warn("close http client resource error : httpGet release connection failed : [params:{httpEntity:{}},httpGet:{},response:{}]",
                    JsonUtil.beanToJson(httpEntity), JsonUtil.beanToJson(httpPost), JsonUtil.beanToJson(response), e);
        }
    }


    public static void main(String[] args) throws IOException, URISyntaxException {
        HttpClientUtil.doGet("http://www.xinxindai.com", null, "UTF-8");
    }
}



