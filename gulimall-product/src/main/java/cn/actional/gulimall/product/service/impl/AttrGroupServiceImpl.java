package cn.actional.gulimall.product.service.impl;

import cn.actional.common.utils.GulimallStringUtils;
import cn.actional.common.utils.PageUtils;
import cn.actional.common.utils.Query;
import cn.actional.gulimall.product.constant.CommonConstant;
import cn.actional.gulimall.product.dao.AttrGroupDao;
import cn.actional.gulimall.product.entity.AttrGroupEntity;
import cn.actional.gulimall.product.service.AttrGroupService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 属性分组
 *
 * @author actional
 * @email 854356662@qq.com
 * @date 2021-04-15 13:41:07
 */
@Service("attrGroupService")
public class AttrGroupServiceImpl extends ServiceImpl<AttrGroupDao, AttrGroupEntity> implements AttrGroupService {

    /**
     * 数据库字段： 属性组id
     */
    public static final String ATTR_GROUP_ID = "attr_group_id";

    /**
     * 数据库字段： 属性组名
     */
    public static final String ATTR_GROUP_NAME = "attr_group_name";

    /**
     * 数据库字段： 分类id
     */
    public static final String CATELOG_ID = "catelog_id";


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AttrGroupEntity> page = this.page(
                new Query<AttrGroupEntity>().getPage(params),
                new QueryWrapper<AttrGroupEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params, Long catelogId) {
        if (catelogId == 0) {
            return this.queryPage(params);
        }
        QueryWrapper<AttrGroupEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(CATELOG_ID, catelogId);
        String key = (String) params.get(CommonConstant.KEY);
        if (GulimallStringUtils.isNotBlank(key)) {
            wrapper.and(obj ->
                    obj.eq(ATTR_GROUP_ID, key).or()
                            .like(ATTR_GROUP_NAME, key)
            );
        }
        IPage<AttrGroupEntity> page = this.page(
                new Query<AttrGroupEntity>().getPage(params),
                wrapper
        );
        return new PageUtils(page);
    }

}
