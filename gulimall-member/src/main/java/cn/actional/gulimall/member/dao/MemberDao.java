package cn.actional.gulimall.member.dao;

import cn.actional.gulimall.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author actional
 * @email 854356662@qq.com
 * @date 2021-04-15 15:40:27
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
