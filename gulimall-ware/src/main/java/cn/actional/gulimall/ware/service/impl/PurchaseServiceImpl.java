package cn.actional.gulimall.ware.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.actional.common.utils.PageUtils;
import cn.actional.common.utils.Query;

import cn.actional.gulimall.ware.dao.PurchaseDao;
import cn.actional.gulimall.ware.entity.PurchaseEntity;
import cn.actional.gulimall.ware.service.PurchaseService;

/**
 * 采购信息
 *
 * @author actional
 * @email 854356662@qq.com
 * @date 2021-04-15 15:55:26
 */
@Service("purchaseService")
public class PurchaseServiceImpl extends ServiceImpl<PurchaseDao, PurchaseEntity> implements PurchaseService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<PurchaseEntity> page = this.page(
                new Query<PurchaseEntity>().getPage(params),
                new QueryWrapper<PurchaseEntity>()
        );

        return new PageUtils(page);
    }

}
