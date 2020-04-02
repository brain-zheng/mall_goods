package com.mall.goodscenter.service.converter;


import com.mall.goodscenter.client.dto.GoodsCategoryDTO;
import com.mall.goodscenter.dal.dataobject.GoodsCategoryDO;

/**
 * @author zheng haijain
 * @createTime 2020-04-01 16:58
 * @description
 */
public class MallGoodsCategoryConverter {

    public static GoodsCategoryDTO goodsCategoryDO2DTO(GoodsCategoryDO goodsCategoryDO) {
        if (goodsCategoryDO == null) {
            return null;
        }
        GoodsCategoryDTO goodsCategoryDTO = new GoodsCategoryDTO();
        goodsCategoryDTO.setCategoryLevel(goodsCategoryDO.getCategoryLevel());
        goodsCategoryDTO.setParentId(goodsCategoryDO.getParentId());
        goodsCategoryDTO.setCategoryName(goodsCategoryDO.getCategoryName());
        goodsCategoryDTO.setCategoryRank(goodsCategoryDO.getCategoryRank());
        goodsCategoryDTO.setDeleted(goodsCategoryDO.getDeleted());
        goodsCategoryDTO.setId(goodsCategoryDO.getId());
        goodsCategoryDTO.setCreateTime(goodsCategoryDO.getCreateTime());
        goodsCategoryDTO.setUpdateTime(goodsCategoryDO.getUpdateTime());
        return goodsCategoryDTO;
    }

    public static GoodsCategoryDO goodsCategoryDTO2DO(GoodsCategoryDTO goodsCategoryDTO) {
        if (goodsCategoryDTO == null) {
            return null;
        }
        GoodsCategoryDO goodsCategoryDO = new GoodsCategoryDO();
        goodsCategoryDO.setCategoryLevel(goodsCategoryDTO.getCategoryLevel());
        goodsCategoryDO.setParentId(goodsCategoryDTO.getParentId());
        goodsCategoryDO.setCategoryName(goodsCategoryDTO.getCategoryName());
        goodsCategoryDO.setCategoryRank(goodsCategoryDTO.getCategoryRank());
        goodsCategoryDO.setDeleted(goodsCategoryDTO.getDeleted());
        goodsCategoryDO.setId(goodsCategoryDTO.getId());
        goodsCategoryDO.setCreateTime(goodsCategoryDTO.getCreateTime());
        goodsCategoryDO.setUpdateTime(goodsCategoryDTO.getUpdateTime());
        return goodsCategoryDO;
    }

}
