package com.mall.goodscenter.dal.dao;

import com.mall.goodscenter.dal.dataobject.GoodsCategoryDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zheng haijain
 * @createTime 2020-04-01 16:21
 * @description
 */
public interface GoodsCategoryDAO extends BaseDAO<GoodsCategoryDO>{

    List<GoodsCategoryDO> findGoodsCategoryList(Integer start, Integer limit, String categoryLevel, String parentId);

    int getTotalGoodsCategories(String categoryLevel, String parentId);

    GoodsCategoryDO selectByLevelAndName(@Param("categoryLevel") Byte categoryLevel, @Param("categoryName") String categoryName);

    int insertSelective(GoodsCategoryDO record);

    int deleteBatch(Integer[] ids);

    List<GoodsCategoryDO> selectByLevelAndParentIdsAndNumber(@Param("parentIds") List<Integer> parentIds, @Param("categoryLevel") int categoryLevel, @Param("number") int number);

}
