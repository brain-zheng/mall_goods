package com.mall.goodscenter.service.manager;

import com.mall.common.service.util.PageQueryUtil;
import com.mall.common.service.util.PageResult;
import com.mall.goodscenter.client.dto.GoodsCategoryDTO;
import com.mall.goodscenter.client.dto.SearchPageCategoryDTO;
import com.mall.goodscenter.client.enums.MallCategoryLevelEnum;
import com.mall.goodscenter.dal.dao.GoodsCategoryDAO;
import com.mall.goodscenter.dal.dataobject.GoodsCategoryDO;
import com.mall.goodscenter.service.converter.MallGoodsCategoryConverter;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zheng haijain
 * @createTime 2020-04-01 16:07
 * @description
 */
@Component
public class MallCategoryManager {

    @Resource
    private GoodsCategoryDAO goodsCategoryDAO;

    public PageResult getCategoriesPage(PageQueryUtil pageUtil, String categoryLevel, String parentId){
        List<GoodsCategoryDO> goodsCategories = goodsCategoryDAO.findGoodsCategoryList(pageUtil.getStart(), pageUtil.getLimit(), categoryLevel, parentId);
        int total = goodsCategoryDAO.getTotalGoodsCategories(categoryLevel, parentId);
        List<GoodsCategoryDTO> goodsCategoryDTOS = new ArrayList<>();
        for(GoodsCategoryDO goodsCategoryDO : goodsCategories) {
            goodsCategoryDTOS.add(MallGoodsCategoryConverter.goodsCategoryDO2DTO(goodsCategoryDO));
        }
        return new PageResult(goodsCategoryDTOS, total, pageUtil.getLimit(), pageUtil.getPage());
    }

    public GoodsCategoryDTO selectByLevelAndName(Byte categoryLevel, String categoryName) {
        GoodsCategoryDO goodsCategoryDO = goodsCategoryDAO.selectByLevelAndName(categoryLevel, categoryName);
        GoodsCategoryDTO goodsCategoryDTO = MallGoodsCategoryConverter.goodsCategoryDO2DTO(goodsCategoryDO);
        return goodsCategoryDTO;
    }

    public int insertSelective(GoodsCategoryDTO record){
        GoodsCategoryDO goodsCategoryDO = MallGoodsCategoryConverter.goodsCategoryDTO2DO(record);
        if (goodsCategoryDO == null) {
            return 0;
        }
        return goodsCategoryDAO.insertSelective(goodsCategoryDO);
    }

    public GoodsCategoryDTO getById(Integer categoryId){
        GoodsCategoryDO goodsCategoryDO = goodsCategoryDAO.getById(categoryId);
        if (goodsCategoryDO == null){
            return null;
        }
        return MallGoodsCategoryConverter.goodsCategoryDO2DTO(goodsCategoryDO);
    }

    public int update(GoodsCategoryDTO record){
        GoodsCategoryDO goodsCategoryDO = MallGoodsCategoryConverter.goodsCategoryDTO2DO(record);
        if (goodsCategoryDO == null) {
            return 0;
        }
        return goodsCategoryDAO.update(goodsCategoryDO);
    }

    public int deleteBatch(Integer[] ids) {
        return goodsCategoryDAO.deleteBatch(ids);
    }

    public List<GoodsCategoryDTO> selectByLevelAndParentIdsAndNumber(List<Integer> parentIds, int categoryLevel, int number) {
        List<GoodsCategoryDO> goodsCategoryDOS = goodsCategoryDAO.selectByLevelAndParentIdsAndNumber(parentIds, categoryLevel, number);
        if (goodsCategoryDOS == null || goodsCategoryDOS.size() == 0) {
            return null;
        }
        List<GoodsCategoryDTO> goodsCategoryDTOS = new ArrayList<>();
        for (GoodsCategoryDO goodsCategoryDO : goodsCategoryDOS) {
            goodsCategoryDTOS.add(MallGoodsCategoryConverter.goodsCategoryDO2DTO(goodsCategoryDO));
        }
        return goodsCategoryDTOS;
    }

    public SearchPageCategoryDTO getCategoriesForSearch(Integer categoryId) {
        SearchPageCategoryDTO searchPageCategoryDTO = new SearchPageCategoryDTO();
        GoodsCategoryDO thirdLevelGoodsCategoryDO = goodsCategoryDAO.getById(categoryId);
        GoodsCategoryDTO thirdLevelGoodsCategory = MallGoodsCategoryConverter.goodsCategoryDO2DTO(thirdLevelGoodsCategoryDO);
        if (thirdLevelGoodsCategory != null && thirdLevelGoodsCategory.getCategoryLevel() == MallCategoryLevelEnum.LEVEL_THREE.getLevel()) {
            //获取当前三级分类的二级分类
            GoodsCategoryDO secondLevelGoodsCategoryDO = goodsCategoryDAO.getById(thirdLevelGoodsCategory.getParentId());
            GoodsCategoryDTO secondLevelGoodsCategory = MallGoodsCategoryConverter.goodsCategoryDO2DTO(secondLevelGoodsCategoryDO);
            if (secondLevelGoodsCategory != null && secondLevelGoodsCategory.getCategoryLevel() == MallCategoryLevelEnum.LEVEL_TWO.getLevel()) {
                //获取当前二级分类下的三级分类List
                List<GoodsCategoryDO> thirdLevelCategoriesDO = goodsCategoryDAO.selectByLevelAndParentIdsAndNumber(Collections.singletonList(secondLevelGoodsCategory.getId()), MallCategoryLevelEnum.LEVEL_THREE.getLevel(), 8);
                List<GoodsCategoryDTO> thirdLevelCategories = thirdLevelCategoriesDO.stream().map(MallGoodsCategoryConverter::goodsCategoryDO2DTO).collect(Collectors.toList());
                searchPageCategoryDTO.setCurrentCategoryName(thirdLevelGoodsCategory.getCategoryName());
                searchPageCategoryDTO.setSecondLevelCategoryName(secondLevelGoodsCategory.getCategoryName());
                searchPageCategoryDTO.setThirdLevelCategoryList(thirdLevelCategories);
                return searchPageCategoryDTO;
            }
        }
        return null;
    }
}
