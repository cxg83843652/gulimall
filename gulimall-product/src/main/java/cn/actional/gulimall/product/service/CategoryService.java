package cn.actional.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import cn.actional.common.utils.PageUtils;
import cn.actional.gulimall.product.entity.CategoryEntity;

import java.util.List;
import java.util.Map;

/**
 * 商品三级分类
 *
 * @author actional
 * @email 854356662@qq.com
 * @date 2021-04-15 13:41:07
 */
public interface CategoryService extends IService<CategoryEntity> {

    /**
     *  条件查询
     * @param params 参数
     * @return 分页数据
     */
    PageUtils queryPage(Map<String, Object> params);

    /**
     *  查询所有分类，组装成树型结构
     * @return list
     */
    List<CategoryEntity> listWithTree();

    /**
     *  根据传入的id数组删除对应的分类
     * @param ids  id数组
     */
    void removeMenuByIds(List<Long> ids);

    /**
     *  获取3级分类的完整路径， 即所有层级
     * @param catelogId     分类id
     * @return              层级
     */
    Long[] findCatelogPath(Long catelogId);
}

