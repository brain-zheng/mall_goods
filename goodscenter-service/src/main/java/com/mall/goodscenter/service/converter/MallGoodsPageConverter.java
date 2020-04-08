package com.mall.goodscenter.service.converter;

import com.mall.goodscenter.client.dto.MallGoodsPageDTO;
import com.mall.goodscenter.dal.dataobject.GoodsInfoPageDO;
import org.springframework.stereotype.Component;

/**
 * @author zheng haijain
 * @createTime 2020-04-07 19:18
 * @description
 */
@Component
public class MallGoodsPageConverter {

    public static MallGoodsPageDTO do2dto(GoodsInfoPageDO pageDO) {
        if (pageDO == null) {
            return null;
        }
        MallGoodsPageDTO mallGoodsPageDTO = new MallGoodsPageDTO();
        mallGoodsPageDTO.setGoodsName(pageDO.getGoodsName());
        mallGoodsPageDTO.setGoodsSellStatus(pageDO.getGoodsSellStatus());
        mallGoodsPageDTO.setStartTime(pageDO.getStartTime());
        mallGoodsPageDTO.setEndTime(pageDO.getEndTime());
        mallGoodsPageDTO.setStart(pageDO.getStart());
        mallGoodsPageDTO.setLimit(pageDO.getLimit());
        mallGoodsPageDTO.setPage(pageDO.getPage());
        mallGoodsPageDTO.setKeyWord(pageDO.getKeyWord());
        mallGoodsPageDTO.setGoodsCategoryId(pageDO.getGoodsCategoryId());
        mallGoodsPageDTO.setOrderBy(pageDO.getOrderBy());
        return mallGoodsPageDTO;
    }

    public static GoodsInfoPageDO dto2do(MallGoodsPageDTO pageDTO) {
        if (pageDTO == null) {
            return null;
        }
        GoodsInfoPageDO goodsInfoPageDO = new GoodsInfoPageDO();
        goodsInfoPageDO.setGoodsName(pageDTO.getGoodsName());
        goodsInfoPageDO.setGoodsSellStatus(pageDTO.getGoodsSellStatus());
        goodsInfoPageDO.setStartTime(pageDTO.getStartTime());
        goodsInfoPageDO.setEndTime(pageDTO.getEndTime());
        goodsInfoPageDO.setStart(pageDTO.getStart());
        goodsInfoPageDO.setLimit(pageDTO.getLimit());
        goodsInfoPageDO.setPage(pageDTO.getPage());
        goodsInfoPageDO.setKeyWord(pageDTO.getKeyWord());
        goodsInfoPageDO.setGoodsCategoryId(pageDTO.getGoodsCategoryId());
        goodsInfoPageDO.setOrderBy(pageDTO.getOrderBy());
        return goodsInfoPageDO;
    }

}
