

package com.zdf.beta.sina.weibo.controller;

import com.zdf.beta.appframe.consts.AppConsts;
import com.zdf.beta.utils.http.HttpClientUtil;
import com.zdf.beta.utils.lang.StringUtil;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/sina/interface/")
public class SinaWeiBoController {

    private Logger LOGGER = org.slf4j.LoggerFactory.getLogger(SinaWeiBoController.class);

    @Value("${sina_app_key}")
    private String client_id;

    @Value("${sina_app_secret}")
    private String client_secret;

    @Value("${sina_uid_code}")
    private String code;

    @Value("${sina_access_token}")
    private String accessToken;

    @Value("${sina_uid}")
    private String uid;

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
        params.put("client_id", client_id);
        params.put("client_secret", client_secret);
        params.put("grant_type", "authorization_code");
        params.put("code", code);
        params.put("redirect_uri", "http://www.oncepush.com/sina/interface/accredit/callback.html");

        //请求头参数
        Map<String, String> header = new HashMap();
        header.put("Content-type", "application/x-www-form-urlencoded");
        header.put("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

        //发送请求
        String body = HttpClientUtil.doPost("https://api.weibo.com/oauth2/access_token", params, header, AppConsts.APP_ENCODING);

        //todo对应登录后页面
        return "/index";
    }


    /**
     * 发布一条微博 true表示必填
     * access_token	true	string	采用OAuth授权方式为必填参数，OAuth授权后获得。
     * status	true	string	要发布的微博文本内容，必须做URLencode，内容不超过140个汉字。
     * visible	false	int	微博的可见性，0：所有人能看，1：仅自己可见，2：密友可见，3：指定分组可见，默认为0。
     * list_id	false	string	微博的保护投递指定分组ID，只有当visible参数为3时生效且必选。
     * lat	false	float	纬度，有效范围：-90.0到+90.0，+表示北纬，默认为0.0。
     * long	false	float	经度，有效范围：-180.0到+180.0，+表示东经，默认为0.0。
     * annotations	false	string	元数据，主要是为了方便第三方应用记录一些适合于自己使用的信息，每条微博可以包含一个或者多个元数据，必须以json字串的形式提交，字串长度不超过512个字符，具体内容可以自定。
     * rip	false	string	开发者上报的操作用户真实IP，形如：211.156.0.1。
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/pushWeibo")
    public String pushWeibo(HttpServletRequest request) throws IOException, URISyntaxException {
        String url = "https://api.weibo.com/2/statuses/update.json";

        //请求参数
        Map<String, String> params = new HashMap();
        params.put("access_token", accessToken);
        params.put("status", "test测试123001");//限制140字内
        params.put("visible", "0");//微博的可见性，0：所有人能看，1：仅自己可见，2：密友可见，3：指定分组可见，默认为0

        //请求头参数
        Map<String, String> header = new HashMap();
        header.put("Content-type", "application/x-www-form-urlencoded");
        header.put("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

        //发送请求N
        String body = HttpClientUtil.doPost(url, params, header, AppConsts.APP_ENCODING);

        //todo对应登录后页面
        return "/index";
    }


    /**
     * access_token	true	string	采用OAuth授权方式为必填参数，OAuth授权后获得。
     * uid	false	int64	需要查询的用户ID。
     * screen_name	false	string	需要查询的用户昵称。
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/userInfo")
    public String getUserInfo(HttpServletRequest request) throws IOException, URISyntaxException {
        String url = "https://api.weibo.com/2/users/show.json";

        Map params = new HashMap();
        params.put("access_token", accessToken);
        params.put("uid", uid);
        //发送请求
        String body = HttpClientUtil.doGet(url, params, AppConsts.APP_ENCODING);
        request.setAttribute("userInfo", body);
        return "userInfo";
    }


}
