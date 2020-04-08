package com.mall.goodscenter.service.service;

import com.mall.common.service.util.PageQueryUtil;
import com.mall.common.service.util.PageResult;
import com.mall.goodscenter.client.dto.GoodsCategoryDTO;
import com.mall.goodscenter.client.service.MallCategoryService;
import com.mall.goodscenter.service.manager.MallCategoryManager;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * @author zheng haijain
 * @createTime 2020-04-01 15:59
 * @description
 */
@Service("MallCategoryServiceImpl")
public class MallCategoryServiceImpl implements MallCategoryService {

    @Resource
    public MallCategoryManager mallCategoryManager;

    @Override
    public PageResult getCategoriesPage(PageQueryUtil pageUtil, String categoryLevel, String parentId) {
        if (pageUtil == null || StringUtils.isEmpty(categoryLevel) || StringUtils.isEmpty(parentId)) {
            return null;
        }
        return mallCategoryManager.getCategoriesPage(pageUtil, categoryLevel, parentId);
    }

    @Override
    public GoodsCategoryDTO selectByLevelAndName(Byte categoryLevel, String categoryName) {
        if (Objects.isNull(categoryLevel) || StringUtils.isEmpty(categoryName)) {
            return null;
        }
        return mallCategoryManager.selectByLevelAndName(categoryLevel, categoryName);
    }

    @Override
    public int insertSelective(GoodsCategoryDTO record) {
        if (record == null) {
            return 0;
        }
        return mallCategoryManager.insertSelective(record);
    }

    @Override
    public GoodsCategoryDTO selectByPrimaryKey(Integer categoryId) {
        if (categoryId == null) {
            return null;
        }
        return mallCategoryManager.getById(categoryId);
    }

    @Override
    public int updateByPrimaryKeySelective(GoodsCategoryDTO record) {
        if (record == null) {
            return 0;
        }
        return mallCategoryManager.update(record);
    }

    @Override
    public Boolean deleteBatch(Integer[] ids) {
        if (ids.length < 1) {
            return false;
        }
        //删除分类数据
        return mallCategoryManager.deleteBatch(ids) > 0;
    }

    @Override
    public List<GoodsCategoryDTO> selectByLevelAndParentIdsAndNumber(List<Integer> parentIds, int categoryLevel) {
        if (parentIds == null || parentIds.size() == 0) {
            return null;
        }
        return mallCategoryManager.selectByLevelAndParentIdsAndNumber(parentIds, categoryLevel, 0);
    }
}
