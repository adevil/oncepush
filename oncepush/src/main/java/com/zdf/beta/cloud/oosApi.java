package com.zdf.beta.cloud;

import org.springframework.beans.factory.annotation.Value;

import java.io.File;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by 13764 on 2016/8/9.
 */
public interface OOSApi {




    /**
     * 普通文件上传(单文件)
     * @param path
     * @param file
     * @return
     * @throws IOException
     */
    public String putFile(String path, File file) throws IOException, InvalidKeyException, NoSuchAlgorithmException;




}
