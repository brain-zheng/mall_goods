package com.mall.goodscenter.client.service;

import com.mall.common.service.util.PageQueryUtil;
import com.mall.common.service.util.PageResult;
import com.mall.goodscenter.client.dto.GoodsCategoryDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zheng haijain
 * @createTime 2020-04-01 15:53
 * @description
 */
public interface MallCategoryService {

    PageResult getCategoriesPage(PageQueryUtil pageUtil, String categoryLevel, String parentId);

    GoodsCategoryDTO selectByLevelAndName(Byte categoryLevel, String categoryName);

    int insertSelective(GoodsCategoryDTO record);

    GoodsCategoryDTO selectByPrimaryKey(Integer categoryId);

    int updateByPrimaryKeySelective(GoodsCategoryDTO record);

    Boolean deleteBatch(Integer[] ids);

    List<GoodsCategoryDTO> selectByLevelAndParentIdsAndNumber(List<Integer> parentIds, int categoryLevel, int number);


}
