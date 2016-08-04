/***********************************************************************
 * Module:  SinaWeiBoController.java
 * Author:  y
 * Purpose: Defines the Class SinaWeiBoController
 ***********************************************************************/

package com.zdf.beta.sina.weibo.controller;

import com.zdf.beta.utils.http.HttpClientUtil;
import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/sina/interface/")
public class SinaWeiBoController {

    private Logger LOGGER  = org.slf4j.LoggerFactory.getLogger(SinaWeiBoController.class);

    /**
     * 授权回调
     *
     * @return
     */
    @RequestMapping(value = "/accredit/callback")
    public String accreditCallBack(HttpServletRequest request) throws IOException, URISyntaxException {
        String code = request.getParameter("code");
        String status = request.getParameter("status");


        //封装参数
        Map params = new HashMap();
        params.put("client_id", "3420153323");
        params.put("client_id", "3420153323");
        params.put("client_secret", "cc384e4503514e9e103a51bfcd256c82");
        params.put("grant_type", "authorization_code");
        params.put("code", code);
        params.put("redirect_uri", "http://www.oncepush.com/");

        //发送请求
        String responseStr = HttpClientUtil.doGet("https://api.weibo.com/oauth2/access_token", params, "UTF-8");

        return null;
    }


    @RequestMapping(value = "/oauth2/accesstoken/callback")
    public String getOAuth2AccessTokenCallBack(HttpServletRequest request) {
        String access_token = request.getParameter("access_token");
        String expires_in = request.getParameter("expires_in");
        String remind_in = request.getParameter("remind_in");
        String uid = request.getParameter("uid");

        LOGGER.debug("access_token:{},expires_in:{},remind_in:{},uid:{}",access_token,expires_in,remind_in,uid);
        return null;
    }


}
