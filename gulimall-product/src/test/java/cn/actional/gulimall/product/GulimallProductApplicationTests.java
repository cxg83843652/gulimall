package cn.actional.gulimall.product;

import cn.actional.gulimall.product.entity.BrandEntity;
import cn.actional.gulimall.product.service.BrandService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GulimallProductApplicationTests {

    private BrandService brandService;

    @Autowired
    public void setBrandService(BrandService brandService) {
        this.brandService = brandService;
    }

    @Test
    public void contextLoads() {
        //BrandEntity brandEntity = new BrandEntity();
        //brandEntity.setBrandId(1L);
        //brandEntity.setDescript("华为");
        //brandEntity.setName("华为");
        //brandService.save(brandEntity);
        //System.out.println("保存成功");
        //brandService.updateById(brandEntity);
        BrandEntity one = brandService.getOne(new QueryWrapper<BrandEntity>().eq("brand_id", 1L));
        System.out.println(one);
    }

}
