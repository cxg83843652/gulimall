package cn.actional.gulimall.thirdparty.controller;

import cn.actional.common.utils.R;
import cn.actional.gulimall.thirdparty.config.ObjectStorageConfig;
import com.aliyun.oss.OSS;
import com.aliyun.oss.common.utils.BinaryUtil;
import com.aliyun.oss.model.MatchMode;
import com.aliyun.oss.model.PolicyConditions;
import io.minio.GetPresignedObjectUrlArgs;
import io.minio.MinioClient;
import io.minio.http.Method;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author actional
 * @email 854356662@qq.com
 * @date 2021/4/19 5:14 PM
 */
@RestController
public class OssController {

    private OSS ossClient;
    private MinioClient minioClient;

    @Autowired
    public void setMinioClient(MinioClient minioClient) {
        this.minioClient = minioClient;
    }

    @Resource
    public void setOssClient(OSS ossClient) {
        this.ossClient = ossClient;
    }

    @RequestMapping("/oss/policy")
    public R ossPolicy() {
        // https://actional-gulimall.oss-cn-guangzhou.aliyuncs.com/attr-add-or-update.vue
        String host = "https://" + ObjectStorageConfig.aliossBucket + "." + ObjectStorageConfig.aliossEndpoint;
        // callbackUrl为 上传回调服务器的URL，请将下面的IP和Port配置为您自己的真实信息。
        // String callbackUrl = "http://88.88.88.88:8888";
        // 用户上传文件时指定的前缀。
        String format = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
        String dir = format + "/";
        Map<String, String> respMap = null;
        // 创建OSSClient实例。
        try {
            long expireTime = 30;
            long expireEndTime = System.currentTimeMillis() + expireTime * 1000;
            Date expiration = new Date(expireEndTime);
            // PostObject请求最大可支持的文件大小为5 GB，即CONTENT_LENGTH_RANGE为5*1024*1024*1024。
            PolicyConditions policyConds = new PolicyConditions();
            policyConds.addConditionItem(PolicyConditions.COND_CONTENT_LENGTH_RANGE, 0, 1048576000);
            policyConds.addConditionItem(MatchMode.StartWith, PolicyConditions.COND_KEY, dir);

            String postPolicy = ossClient.generatePostPolicy(expiration, policyConds);
            byte[] binaryData = postPolicy.getBytes("utf-8");
            String encodedPolicy = BinaryUtil.toBase64String(binaryData);
            String postSignature = ossClient.calculatePostSignature(postPolicy);

            respMap = new LinkedHashMap<String, String>();
            respMap.put("accessid", ObjectStorageConfig.aliossAccessKey);
            respMap.put("policy", encodedPolicy);
            respMap.put("signature", postSignature);
            respMap.put("dir", dir);
            respMap.put("host", host);
            respMap.put("expire", String.valueOf(expireEndTime / 1000));
            // respMap.put("expire", formatISO8601Date(expiration));
        } catch (Exception e) {
            // Assert.fail(e.getMessage());
            System.out.println(e.getMessage());
        } finally {
            ossClient.shutdown();
        }
        return R.ok().put("data", respMap);
    }


    @GetMapping("/minio/policy")
    public R monioPolicy(@RequestParam(value = "filename") String filename) throws Exception {
        System.out.println(filename);
        filename = new SimpleDateFormat("yyyy/MM/dd").format(new Date()) + "/" + filename;
        Map<String, String> reqParams = new HashMap<String, String>(8);
        reqParams.put("Content-Type", "application/octet-stream");
        // 获取minio 预签名url
        String presignedUrl = minioClient.getPresignedObjectUrl(GetPresignedObjectUrlArgs.builder()
                .method(Method.PUT)
                .bucket("gulimall")
                .object(filename)
                .expiry(60 * 60 * 24)
                .extraQueryParams(reqParams)
                .build());
        return R.ok().put("data", presignedUrl);
    }
}
