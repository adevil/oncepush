package com.zdf.beta.cloud.ucloud.oos;

import com.zdf.beta.appframe.consts.AppConsts;
import com.zdf.beta.cloud.OOSApi;
import com.zdf.beta.cloud.exception.CloudApiCallException;
import com.zdf.beta.utils.http.ContentTypeMap;
import com.zdf.beta.utils.http.HttpClientUtil;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

/**
 * Created by 13764 on 2016/8/10.
 */
@Service
public class UFileUploaderApi implements OOSApi {

    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());


    //云服务商密钥
    @Value("${ucloud_private_key}")
    private String privateKey;

    //云服务商公钥
    @Value("${ucloud_public_key}")
    private String publicKey;

    //UFILE服务器域名
    @Value("${ucloud_ufile_domain_name}")
    private String UFILE_HOST;

    @Value("${ucloud_bucket_name}")
    private String bucket_name;

    /**
     * PUT /<key_name> HTTP/1.1
     * Host: <bucket_name>.ufile.ucloud.cn
     * Authorization: <token>
     * Content-Length: <length>
     * Content-Type: <mimetype>
     * Content-MD5: <md5>
     *
     * @param dirPath 存放的目录文件夹
     * @param file
     * @return
     */
    public String simpleFileUpload(String dirPath, File file) throws IOException {
        LOGGER.info("simple file upload start : {params:{path:{},file:{}}}", dirPath, file);

        if (file == null) {
            LOGGER.error("simple file upload error : file object is null :{params:{path:{},file:{}}}", dirPath, file);
            throw new CloudApiCallException();
        }

        //计算Content-MD5
        FileInputStream fis = new FileInputStream(file);
        byte[] bytes = DigestUtils.md5(fis);
        String contentMd5 = Base64.encodeBase64String(bytes);
        //获取内容类型
        String contentType = ContentTypeMap.EXT_TO_CONTENT_TYPE.get(file.getName().substring(file.getName().lastIndexOf(".") + 1));

        this.getSignature(dirPath, file, contentMd5, contentType, new Date());


        //设置请求头参数
        Map<String, String> header = new HashMap<String, String>();
        //todo String url = UFILE_HOST +  + file.getName();
        String url = null;
        //header.put("Authorization", );
        header.put("Content-Length", String.valueOf(file.length()));
        header.put("Content-MD5", contentMd5);
        //获取内容类型
        header.put("Content-Type", contentType);
        List<File> files = new ArrayList<File>();
        files.add(file);
        return HttpClientUtil.doMultiPost(url, null, null, files, AppConsts.APP_ENCODING);

    }


    /**
     * 获取文件管理签名
     *
     * @return
     * @throws IOException
     */
    private String getSignature(String dirPath, File file, String contentMd5, String contentType, Date date) {


        String key = dirPath+file.getName();
//        String http_verb = "PUT"
//        content_md5 = ""
//        content_type = "image/jpeg"
//        date = ""
//        canonicalized_ucloud_headers = "x-ucloud-foo:foo" + "\n" + "x-ucloud-bar:bar1,bar2" + \n"
//        canonicalized_resource = "/" + "demobucket" + "/" + "demokey"
//        string2sign = "PUT" + "\n"
//                + "" + "\n"
//                + "image/jpg" + "\n"
//                + "" + "\n"
//                + "x-ucloud-foo:foo" + "\n" + "x-ucloud-bar:bar1,bar2" + "\n"
//                + "/demobucket/demokey"

        return null;
    }


}
