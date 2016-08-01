/**
 * Copyright (c) 2014, www.xinxindai.com All Rights Reserved. 
 *
 */
package com.zdf.oncepush.utils.io;



import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * 缩放图片？
 *
 * @version $Id: ZoomImage.java 3279 2014-08-06 03:38:42Z xiaoying $
 * @since jdk1.6
 */
public class ZoomImage {
    public void ZoomTheImage(String fileUrl, String newUrl, int width, int height) throws IOUtilException {
        try {
            java.io.File file = new java.io.File(fileUrl);         //读入刚才上传的文件
            Image src = javax.imageio.ImageIO.read(file);
            //构造Image对象

            BufferedImage tag = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            tag.getGraphics().drawImage(src, 0, 0, width, height, null);        //绘制缩小后的图
            ImageIO.write(tag,  "jpeg" , new File(newUrl)); tag.flush();

        } catch (Throwable e){
            throw new IOUtilException(e);
        }
    }
}
