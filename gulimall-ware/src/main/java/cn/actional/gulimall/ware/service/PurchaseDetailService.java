package cn.actional.gulimall.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import cn.actional.common.utils.PageUtils;
import cn.actional.gulimall.ware.entity.PurchaseDetailEntity;

import java.util.Map;

/**
 * 
 *
 * @author actional
 * @email 854356662@qq.com
 * @date 2021-04-15 15:55:26
 */
public interface PurchaseDetailService extends IService<PurchaseDetailEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

