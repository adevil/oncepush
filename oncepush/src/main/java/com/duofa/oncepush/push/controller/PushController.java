

package com.duofa.oncepush.push.controller;


import com.duofa.oncepush.cloud.ucloud.oos.UFileUploaderApi;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import weibo4j.Oauth;
import weibo4j.model.WeiboException;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@Controller
@RequestMapping(value = "/sina/interface/")
public class PushController {

    private Logger LOGGER = org.slf4j.LoggerFactory.getLogger(PushController.class);

    @Autowired
    private UFileUploaderApi uFileUploaderApi;

    /**
     * 授权回调
     *
     * @return
     */
    @RequestMapping(value = "/accredit/callback")
    public String accreditCallBack(HttpServletRequest request) throws IOException, URISyntaxException, WeiboException {

        String code = request.getParameter("code");

        Oauth oauth = new Oauth();
        oauth.getAccessTokenByCode(code);

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
    @ResponseBody
    public String pushWeibo(String content, HttpServletRequest request) throws IOException, URISyntaxException {


        //todo对应登录后页面
        return null;
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

        return "userInfo";
    }


    /**
     * 图片上传测试
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/uploadTest")
    public String uploadTest(HttpServletRequest request) throws NoSuchAlgorithmException, InvalidKeyException, IOException {
        File file = new File("F:/54DA.tmp.png");
        uFileUploaderApi.putFile("static/img/", file);
        return "/index";
    }


}
