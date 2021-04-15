package cn.actional.gulimall.order.dao;

import cn.actional.gulimall.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author actional
 * @email 854356662@qq.com
 * @date 2021-04-15 15:47:38
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
