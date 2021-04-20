package cn.actional.gulimall.product.service.impl;

import cn.actional.common.utils.PageUtils;
import cn.actional.common.utils.Query;
import cn.actional.gulimall.product.dao.CategoryDao;
import cn.actional.gulimall.product.entity.CategoryEntity;
import cn.actional.gulimall.product.service.CategoryService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 商品三级分类
 *
 * @author actional
 * @email 854356662@qq.com
 * @date 2021-04-15 13:41:07
 */
@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CategoryEntity> listWithTree() {
        // 获取所有分类
        List<CategoryEntity> all = this.list();
        return all.stream().filter(menu -> menu.getParentCid() == 0)
                .peek(menu -> menu.setChildren(getChildrens(menu, all)))
                .sorted(Comparator.comparingInt(menu -> menu.getSort() == null ? 0 : menu.getSort()))
                .collect(Collectors.toList());
    }

    @Override
    public void removeMenuByIds(List<Long> ids) {
        // TODO 不知道具体业务需求，  检查当前删除的菜单，是否被别的地方引用
        this.removeByIds(ids);
        // 逻辑删除
    }

    @Override
    public Long[] findCatelogPath(Long catelogId) {
        List<Long> paths = new ArrayList<>();
        findParentPath(catelogId, paths);
        Collections.reverse(paths);
        return paths.toArray(new Long[0]);
    }

    private void findParentPath(Long catelogId, List<Long> paths) {
        paths.add(catelogId);
        CategoryEntity entity = this.getById(catelogId);
        if (entity.getParentCid() != 0) {
            findParentPath(entity.getParentCid(), paths);
        }
    }

    /**
     * 获取当前节点的所有子节点
     *
     * @param parent 父节点
     * @param all    所有节点
     * @return 父节点的所有子节点
     */
    private List<CategoryEntity> getChildrens(CategoryEntity parent, List<CategoryEntity> all) {
        return all.stream().filter(menu -> parent.getCatId().equals(menu.getParentCid()))
                // 递归继续查找子节点
                .peek(menu -> menu.setChildren(getChildrens(menu, all)))
                .sorted(Comparator.comparingInt(menu -> menu.getSort() == null ? 0 : menu.getSort()))
                .collect(Collectors.toList());
    }


}
