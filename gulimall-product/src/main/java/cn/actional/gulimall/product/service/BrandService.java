package cn.actional.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import cn.actional.common.utils.PageUtils;
import cn.actional.gulimall.product.entity.BrandEntity;

import java.util.Map;

/**
 * 品牌
 *
 * @author actional
 * @email 854356662@qq.com
 * @date 2021-04-15 13:41:07
 */
public interface BrandService extends IService<BrandEntity> {

    /**
     *  分页条件查询
     * @param params 条件
     * @return       分页数据
     */
    PageUtils queryPage(Map<String, Object> params);
}

