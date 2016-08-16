package com.duofa.util.io;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by 13764 on 2016/8/15.
 */
public class ImgIOUtils {

    /**
     * 根据图片名称，读取成字符数组
     *
     * @param filename
     * @return
     * @throws IOException
     */
    public static byte[] readFileImage(String filename) throws IOException {
        BufferedInputStream bufferedInputStream = null;
        byte[] bytes = null;
        try {
            bufferedInputStream = new BufferedInputStream(
                    new FileInputStream(filename));
            int len = bufferedInputStream.available();
            bytes = new byte[len];
            int r = bufferedInputStream.read(bytes);
            if (len != r) {
                bytes = null;
                throw new IOException(filename + "image file read error");
            }
        } finally {
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
        }
        return bytes;
    }


    /**
     * 缩放图片
     *
     * @param fileUrl
     * @param newUrl
     * @param width
     * @param height
     * @throws IOUtilException
     */
    @Deprecated
    public void ZoomTheImage(String fileUrl, String newUrl, int width, int height) throws IOUtilException {
        try {
            File file = new File(fileUrl);         //读入文件
            Image src = ImageIO.read(file);
            //构造Image对象

            BufferedImage tag = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            tag.getGraphics().drawImage(src, 0, 0, width, height, null);        //绘制缩小后的图
            ImageIO.write(tag, "jpeg", new File(newUrl));
            tag.flush();

        } catch (Throwable e) {
            throw new IOUtilException(e);
        }
    }

}
