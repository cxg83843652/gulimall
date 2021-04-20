package cn.actional.gulimall.product.service.impl;

import cn.actional.common.utils.GulimallStringUtils;
import cn.actional.common.utils.PageUtils;
import cn.actional.common.utils.Query;
import cn.actional.gulimall.product.constant.CommonConstant;
import cn.actional.gulimall.product.dao.BrandDao;
import cn.actional.gulimall.product.entity.BrandEntity;
import cn.actional.gulimall.product.service.BrandService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 品牌
 *
 * @author actional
 * @email 854356662@qq.com
 * @date 2021-04-15 13:41:07
 */
@Service("brandService")
public class BrandServiceImpl extends ServiceImpl<BrandDao, BrandEntity> implements BrandService {

    public static final String BRAND_ID = "brand_id";
    public static final String NAME = "name";

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        QueryWrapper<BrandEntity> wrapper = new QueryWrapper<>();
        String key = (String) params.get(CommonConstant.KEY);
        if (GulimallStringUtils.isNotBlank(key)) {
            wrapper.eq(BRAND_ID, key).or().like(NAME, key);
        }
        IPage<BrandEntity> page = this.page(
                new Query<BrandEntity>().getPage(params),
                wrapper
        );

        return new PageUtils(page);
    }

}
