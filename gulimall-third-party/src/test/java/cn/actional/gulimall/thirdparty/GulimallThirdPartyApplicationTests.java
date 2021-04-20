package cn.actional.gulimall.thirdparty;

import com.aliyun.oss.OSSClient;
import io.minio.GetPresignedObjectUrlArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.errors.MinioException;
import io.minio.http.Method;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.FileInputStream;
import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GulimallThirdPartyApplicationTests {

    private MinioClient minioClient;
    private OSSClient ossClient;

    @Autowired
    public void setMinioClient(MinioClient minioClient) {
        this.minioClient = minioClient;
    }

    @Resource
    public void setOssClient(OSSClient ossClient) {
        this.ossClient = ossClient;
    }


    @Test
    public void testMinioUpload() {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("/Users/actional/Documents/Documents/JavaCode/javaCase/gulimall1/docs/product-generator/main/resources/src/views/modules/product/attr-add-or-update.vue");
            minioClient.putObject(PutObjectArgs.builder().bucket("gulimall")
                    .object("1/2/3/attr-add-or-update.vue").stream(fis, fis.available(), -1)
                    .contentType("image/png")
                    .build());
        } catch (MinioException e) {
            System.out.println("Error occurred: " + e);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    @Test
    public void testAliossUpload() throws Exception {
        FileInputStream fis = new FileInputStream("/Users/actional/Documents/Documents/JavaCode/javaCase/gulimall1/docs/product-generator/main/resources/src/views/modules/product/attr-add-or-update.vue");
        ossClient.putObject("actional-gulimall", "attr-add-or-update.vue", fis);
        ossClient.shutdown();
        System.out.println("上传完成");
        fis.close();
    }


    @Test
    public void testMinioPreSined() throws Exception {
        // 获取minio 预签名url
        String presignedUrl = minioClient.getPresignedObjectUrl(GetPresignedObjectUrlArgs.builder()
                .method(Method.GET)
                .bucket("gulimall")
                .object("aaa.vue")
                .expiry(60 * 60 * 24)
                .build());
        System.out.println(presignedUrl);
    }

}
