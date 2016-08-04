

package com.zdf.beta.sina.weibo.controller;

import com.zdf.beta.utils.http.HttpClientUtil;
import com.zdf.beta.utils.lang.StringUtil;
import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/sina/interface/")
public class SinaWeiBoController {

    private Logger LOGGER = org.slf4j.LoggerFactory.getLogger(SinaWeiBoController.class);

    /**
     * 授权回调
     *
     * @return
     */
    @RequestMapping(value = "/accredit/callback")
    public String accreditCallBack(HttpServletRequest request) throws IOException, URISyntaxException {

        String code = request.getParameter("code");
        LOGGER.debug("code:" + code);

        //封装参数
        Map params = new HashMap();
        params.put("client_id", "3420153323");
        params.put("client_secret", "cc384e4503514e9e103a51bfcd256c82");
        params.put("grant_type", "authorization_code");
        params.put("code", code);
        params.put("redirect_uri", "http://www.oncepush.com/sina/interface/accredit/callback.html");

        //发送请求
        String body = HttpClientUtil.doPost("https://api.weibo.com/oauth2/access_token", params, "UTF-8");


        //todo对应登录后页面
        return "/index";
    }


}
