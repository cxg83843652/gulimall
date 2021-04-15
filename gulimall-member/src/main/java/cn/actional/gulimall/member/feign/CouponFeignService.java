package cn.actional.gulimall.member.feign;

import cn.actional.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author actional
 * @email 854356662@qq.com
 * @date 2021/4/15 5:16 PM
 */
@FeignClient("gulimall-coupon")
public interface CouponFeignService {

    /**
     *  调用coupon服务 优惠券功能
     * @return  R
     */
    @RequestMapping("/coupon/coupon/member/list")
    public R membercoupons();
}
