package com.duofa.oncepush.cloud.ucloud.oos;

import cn.ucloud.ufile.UFileClient;
import cn.ucloud.ufile.UFileRequest;
import cn.ucloud.ufile.UFileResponse;
import cn.ucloud.ufile.sender.PutSender;
import com.duofa.oncepush.cloud.ucloud.OOSApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by 13764 on 2016/8/10.
 */
@Service
public class UFileUploaderApi implements OOSApi {

    private static Logger LOGGER = LoggerFactory.getLogger(UFileUploaderApi.class);

    // todo 暂时这样，之后修改uflesdk配置
    private String bucket_name = "oncepush";

    /**
     * 普通单文件上传到OOS
     *
     * @param saveDirPath 存放的目录文件夹开头不能有“/”
     * @param file
     * @return
     */
    public String putFile(String saveDirPath, File file) throws IOException, InvalidKeyException, NoSuchAlgorithmException {

        //设置bucketName,key(文件名),本地文件路径
        UFileRequest request = new UFileRequest();
        request.setBucketName(bucket_name);
        request.setKey(saveDirPath + file.getName());
        request.setFilePath(file.getPath());

        UFileClient ufileClient = null;
        try {
            ufileClient = new UFileClient();
            ufileClient.setConfigPath("");
            putFile(ufileClient, request);
        } finally {
            ufileClient.shutdown();
        }
        return null;
    }


    /**
     * 调用ucloud接口上传文件
     *
     * @param ufileClient
     * @param request
     */
    private static String putFile(UFileClient ufileClient, UFileRequest request) {
        String responseStr = null;

        //生成签名
        PutSender sender = new PutSender();
        sender.makeAuth(ufileClient, request);

        //推送数据
        UFileResponse response = sender.send(ufileClient, request);
        if (response != null) {
            return responseStr;
        }

        InputStream inputStream = response.getContent();
        if (inputStream != null) {
            return responseStr;
        }

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            while ((responseStr = reader.readLine()) != null) {
                LOGGER.debug(responseStr);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return responseStr;
    }







}
