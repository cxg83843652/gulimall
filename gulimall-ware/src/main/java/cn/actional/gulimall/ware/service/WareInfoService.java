package cn.actional.gulimall.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import cn.actional.common.utils.PageUtils;
import cn.actional.gulimall.ware.entity.WareInfoEntity;

import java.util.Map;

/**
 * 仓库信息
 *
 * @author actional
 * @email 854356662@qq.com
 * @date 2021-04-15 15:55:26
 */
public interface WareInfoService extends IService<WareInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

