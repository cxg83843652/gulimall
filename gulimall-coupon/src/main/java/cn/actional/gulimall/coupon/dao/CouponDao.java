package cn.actional.gulimall.coupon.dao;

import cn.actional.gulimall.coupon.entity.CouponEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券信息
 * 
 * @author actional
 * @email 854356662@qq.com
 * @date 2021-04-15 15:34:18
 */
@Mapper
public interface CouponDao extends BaseMapper<CouponEntity> {
	
}
