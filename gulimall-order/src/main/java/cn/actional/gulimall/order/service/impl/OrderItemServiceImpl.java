package cn.actional.gulimall.order.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.actional.common.utils.PageUtils;
import cn.actional.common.utils.Query;

import cn.actional.gulimall.order.dao.OrderItemDao;
import cn.actional.gulimall.order.entity.OrderItemEntity;
import cn.actional.gulimall.order.service.OrderItemService;

/**
 * 订单项信息
 *
 * @author actional
 * @email 854356662@qq.com
 * @date 2021-04-15 15:47:38
 */
@Service("orderItemService")
public class OrderItemServiceImpl extends ServiceImpl<OrderItemDao, OrderItemEntity> implements OrderItemService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<OrderItemEntity> page = this.page(
                new Query<OrderItemEntity>().getPage(params),
                new QueryWrapper<OrderItemEntity>()
        );

        return new PageUtils(page);
    }

}
