package cn.actional.gulimall.thirdparty.config;

import io.minio.MinioClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 对象存储相关配置
 *
 * @author actional
 * @email 854356662@qq.com
 * @date 2021/4/19 2:43 PM
 */
@Configuration
public class ObjectStorageConfig {

    /**
     * minio 配置
     */
    public static String minioAccessKey;
    public static String minioSecretKey;
    public static String minioEndpoint;
    /**
     * 阿里oss 配置
     */
    public static String aliossEndpoint;
    public static String aliossBucket;
    public static String aliossAccessKey;


    @Value("${minio.accessKey}")
    public void setMinioAccessKey(String minioAccessKey) {
        ObjectStorageConfig.minioAccessKey = minioAccessKey;
    }

    @Value("${minio.secretKey}")
    public void setMinioSecretKey(String minioSecretKey) {
        ObjectStorageConfig.minioSecretKey = minioSecretKey;
    }

    @Value("${minio.endpoint}")
    public void setMinioEndpoint(String minioEndpoint) {
        ObjectStorageConfig.minioEndpoint = minioEndpoint;
    }

    @Value("${alibaba.cloud.oss.endpoint}")
    public void setAliossEndpoint(String aliossEndpoint) {
        ObjectStorageConfig.aliossEndpoint = aliossEndpoint;
    }

    @Value("${alibaba.cloud.bucket}")
    public void setAliossBucket(String aliossBucket) {
        ObjectStorageConfig.aliossBucket = aliossBucket;
    }

    @Value("${alibaba.cloud.access-key}")
    public void setAliossAccessKey(String aliossAccessKey) {
        ObjectStorageConfig.aliossAccessKey = aliossAccessKey;
    }

    /**
     * minio
     */
    @Bean
    public MinioClient minioClient() {
        return MinioClient.builder().endpoint(minioEndpoint)
                .credentials(minioAccessKey, minioSecretKey).build();
    }


}
