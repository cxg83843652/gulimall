package cn.actional.gulimall.product.dao;

import cn.actional.gulimall.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author actional
 * @email 854356662@qq.com
 * @date 2021-04-15 01:21:44
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
