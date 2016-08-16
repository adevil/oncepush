package com.duofa.sina.weibo.oauth2;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import weibo4j.Oauth;
import weibo4j.http.AccessToken;
import weibo4j.model.WeiboException;

public class OAuth2Api {

    private static Logger LOGGER = LoggerFactory.getLogger(OAuth2Api.class);

    /**
     * 获取OAuth2 accessToken
     *
     * @param code
     * @return
     * @throws WeiboException
     */
    public static AccessToken getOAuth2AccessToken(String code) throws WeiboException {
        Oauth oauth = new Oauth();
        return oauth.getAccessTokenByCode(code);
    }


}
