/**
 * Copyright (c) 2014, www.xinxindai.com All Rights Reserved.
 */
package com.zdf.beta.utils.json;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.ArrayList;
import java.util.List;

/**
 * JSON工具类
 *
 * @version $Id: JsonUtil.java 6498 2014-09-24 03:34:59Z xiaoying $
 */
public class JsonUtil {

    /**
     * 从一个JSON对象字符格式中得到一个java对象
     *
     * @param jsonString JSON字符串
     * @param beanClass  对象类型
     */
    public static <T> T jsonToBean(String jsonString, Class<T> beanClass) {
        return JSONObject.parseObject(jsonString, beanClass);
    }

    /**
     * 将java对象转换成json字符串
     *
     * @param bean java对象
     */
    public static String beanToJson(Object bean) {
        return JSONObject.toJSONString(bean, SerializerFeature.WriteDateUseDateFormat);
    }

    /**
     * 将java对象List集合转换成json字符串
     *
     * @param list 对象List集合
     */
    public static String listToJson(List<?> list) {
        return JSONObject.toJSONString(list, SerializerFeature.WriteDateUseDateFormat);
    }

    /**
     * 从json对象集合表达式中得到一个java对象列表
     *
     * @param jsonString JSON字符串
     * @param beanClass  对象类型
     */
    public static <T> List<T> jsonToList(String jsonString, Class<T> beanClass) {
        JSONArray jsonArray = JSONArray.parseArray(jsonString);

        T bean;
        int size = jsonArray.size();
        List<T> list = new ArrayList<T>(size);
        for (int i = 0; i < size; i++) {
            bean = jsonArray.getObject(i, beanClass);
            list.add(bean);
        }

        return list;
    }


    /**
   	 * 从json数组中得到相应java数组，泛型请使用jsonToList
   	 *
   	 * @param jsonString JSON字符串
   	 */
   	public static Object[] jsonToObjectArray(String jsonString) {
   		JSONArray jsonArray = JSONArray.parseArray(jsonString);
        return jsonArray.toArray();
   	}

}
