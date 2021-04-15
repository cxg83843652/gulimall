package cn.actional.gulimall.coupon.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.actional.common.utils.PageUtils;
import cn.actional.common.utils.Query;

import cn.actional.gulimall.coupon.dao.HomeSubjectSpuDao;
import cn.actional.gulimall.coupon.entity.HomeSubjectSpuEntity;
import cn.actional.gulimall.coupon.service.HomeSubjectSpuService;

/**
 * 专题商品
 *
 * @author actional
 * @email 854356662@qq.com
 * @date 2021-04-15 15:34:18
 */
@Service("homeSubjectSpuService")
public class HomeSubjectSpuServiceImpl extends ServiceImpl<HomeSubjectSpuDao, HomeSubjectSpuEntity> implements HomeSubjectSpuService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<HomeSubjectSpuEntity> page = this.page(
                new Query<HomeSubjectSpuEntity>().getPage(params),
                new QueryWrapper<HomeSubjectSpuEntity>()
        );

        return new PageUtils(page);
    }

}
