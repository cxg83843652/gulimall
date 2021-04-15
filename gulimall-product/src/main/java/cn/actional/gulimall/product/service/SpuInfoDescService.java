package cn.actional.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import cn.actional.common.utils.PageUtils;
import cn.actional.gulimall.product.entity.SpuInfoDescEntity;

import java.util.Map;

/**
 * spu信息介绍
 *
 * @author actional
 * @email 854356662@qq.com
 * @date 2021-04-15 13:41:07
 */
public interface SpuInfoDescService extends IService<SpuInfoDescEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

