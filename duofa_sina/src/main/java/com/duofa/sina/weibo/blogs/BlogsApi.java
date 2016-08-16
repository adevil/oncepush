package com.duofa.sina.weibo.blogs;

import com.duofa.util.io.ImgIOUtils;
import weibo4j.Timeline;
import weibo4j.http.ImageItem;
import weibo4j.model.Status;
import weibo4j.model.WeiboException;

import java.io.*;

/**
 * Created by 13764 on 2016/8/15.
 */
public class BlogsApi {

    /**
     * 发布文字微博
     *
     * @param accessToken
     * @param statues
     * @return
     * @throws WeiboException
     */
    public static Status pushWordBlog(String accessToken, String statues) throws WeiboException {
        Timeline tm = new Timeline(accessToken);
        return tm.updateStatus(statues);
    }

    /**
     * 推送图文博客（单图？）
     *
     * @param accessToken
     * @param statues
     * @param fileName
     * @return
     */
    public static Status pushWordAndImgBlog(String accessToken, String statues, String fileName)
            throws IOException, WeiboException {

        String s = java.net.URLEncoder.encode(statues, "utf-8");
        byte[] content = ImgIOUtils.readFileImage(fileName);
        ImageItem pic = new ImageItem("duoFaPic", content);
        Timeline tm = new Timeline(accessToken);
        return tm.uploadStatus(s, pic);
    }


    //todo 多图


    /**
     * 删除自己发布的微博信息
     *
     * @param accessToken
     * @param blogId
     */
    public static Status destroy(String accessToken, String blogId) throws WeiboException {
        Timeline tm = new Timeline(accessToken);
        return tm.destroy(blogId);
    }


    /**
     * 转发一条微博
     *
     * @param accessToken
     * @param blogId
     * @return
     * @throws WeiboException
     */
    public static Status repost(String accessToken, String blogId) throws WeiboException {
        Timeline tm = new Timeline(accessToken);
        return tm.repost(blogId);
    }

    /**
     * 转发一条微博并添加转发文本
     *
     * @param accessToken
     * @param blogId
     * @param status
     * @param isComment
     * @return
     * @throws WeiboException
     */
    public Status repost(String accessToken, String blogId, String status, Integer isComment) throws WeiboException {
        Timeline tm = new Timeline(accessToken);
        return tm.repost(blogId, status, isComment);
    }


}
