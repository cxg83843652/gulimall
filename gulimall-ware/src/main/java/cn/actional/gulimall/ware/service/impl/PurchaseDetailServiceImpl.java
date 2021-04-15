package cn.actional.gulimall.ware.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.actional.common.utils.PageUtils;
import cn.actional.common.utils.Query;

import cn.actional.gulimall.ware.dao.PurchaseDetailDao;
import cn.actional.gulimall.ware.entity.PurchaseDetailEntity;
import cn.actional.gulimall.ware.service.PurchaseDetailService;

/**
 * 
 *
 * @author actional
 * @email 854356662@qq.com
 * @date 2021-04-15 15:55:26
 */
@Service("purchaseDetailService")
public class PurchaseDetailServiceImpl extends ServiceImpl<PurchaseDetailDao, PurchaseDetailEntity> implements PurchaseDetailService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<PurchaseDetailEntity> page = this.page(
                new Query<PurchaseDetailEntity>().getPage(params),
                new QueryWrapper<PurchaseDetailEntity>()
        );

        return new PageUtils(page);
    }

}
