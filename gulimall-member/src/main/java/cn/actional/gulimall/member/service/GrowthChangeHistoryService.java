package cn.actional.gulimall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import cn.actional.common.utils.PageUtils;
import cn.actional.gulimall.member.entity.GrowthChangeHistoryEntity;

import java.util.Map;

/**
 * 成长值变化历史记录
 *
 * @author actional
 * @email 854356662@qq.com
 * @date 2021-04-15 15:40:27
 */
public interface GrowthChangeHistoryService extends IService<GrowthChangeHistoryEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

