package cn.actional.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import cn.actional.common.utils.PageUtils;
import cn.actional.gulimall.product.entity.AttrGroupEntity;

import java.util.Map;

/**
 * 属性分组
 *
 * @author actional
 * @email 854356662@qq.com
 * @date 2021-04-15 13:41:07
 */
public interface AttrGroupService extends IService<AttrGroupEntity> {

    /**
     *  分页查询所有
     * @param params 分页参数
     * @return       分页对象
     */
    PageUtils queryPage(Map<String, Object> params);

    /**
     *  分页查询通过 catlogId
     * @param params     分页参数
     * @param catelogId  id
     * @return           分页对象
     */
    PageUtils queryPage(Map<String, Object> params, Long catelogId);
}

