package com.mall.goodscenter.service.converter;

import com.mall.goodscenter.client.dto.MallGoodsInfoDTO;
import com.mall.goodscenter.dal.dataobject.GoodsInfoDO;

/**
 * @author zheng haijain
 * @createTime 2020-04-06 20:02
 * @description
 */
public class MallGoodsInfoConverter {

    public static MallGoodsInfoDTO do2dto(GoodsInfoDO goodsInfoDO) {
        if (goodsInfoDO == null) {
            return null;
        }
        MallGoodsInfoDTO mallGoodsInfoDTO = new MallGoodsInfoDTO();
        mallGoodsInfoDTO.setGoodsName(goodsInfoDO.getGoodsName());
        mallGoodsInfoDTO.setGoodsIntro(goodsInfoDO.getGoodsIntro());
        mallGoodsInfoDTO.setGoodsCategoryId(goodsInfoDO.getGoodsCategoryId());
        mallGoodsInfoDTO.setGoodsCoverImg(goodsInfoDO.getGoodsCoverImg());
        mallGoodsInfoDTO.setGoodsCarousel(goodsInfoDO.getGoodsCarousel());
        mallGoodsInfoDTO.setOriginalPrice(goodsInfoDO.getOriginalPrice());
        mallGoodsInfoDTO.setSellingPrice(goodsInfoDO.getSellingPrice());
        mallGoodsInfoDTO.setStockNum(goodsInfoDO.getStockNum());
        mallGoodsInfoDTO.setTag(goodsInfoDO.getTag());
        mallGoodsInfoDTO.setGoodsSellStatus(goodsInfoDO.getGoodsSellStatus());
        mallGoodsInfoDTO.setGoodsDetailContent(goodsInfoDO.getGoodsDetailContent());
        mallGoodsInfoDTO.setId(goodsInfoDO.getId());
        mallGoodsInfoDTO.setCreateTime(goodsInfoDO.getCreateTime());
        mallGoodsInfoDTO.setUpdateTime(goodsInfoDO.getUpdateTime());
        return mallGoodsInfoDTO;
    }

    public static GoodsInfoDO dto2do(MallGoodsInfoDTO goodsInfoDTO) {
        if (goodsInfoDTO == null) {
            return null;
        }
        GoodsInfoDO goodsInfoDO = new GoodsInfoDO();
        goodsInfoDO.setGoodsName(goodsInfoDTO.getGoodsName());
        goodsInfoDO.setGoodsIntro(goodsInfoDTO.getGoodsIntro());
        goodsInfoDO.setGoodsCategoryId(goodsInfoDTO.getGoodsCategoryId());
        goodsInfoDO.setGoodsCoverImg(goodsInfoDTO.getGoodsCoverImg());
        goodsInfoDO.setGoodsCarousel(goodsInfoDTO.getGoodsCarousel());
        goodsInfoDO.setOriginalPrice(goodsInfoDTO.getOriginalPrice());
        goodsInfoDO.setSellingPrice(goodsInfoDTO.getSellingPrice());
        goodsInfoDO.setStockNum(goodsInfoDTO.getStockNum());
        goodsInfoDO.setTag(goodsInfoDTO.getTag());
        goodsInfoDO.setGoodsSellStatus(goodsInfoDTO.getGoodsSellStatus());
        goodsInfoDO.setGoodsDetailContent(goodsInfoDTO.getGoodsDetailContent());
        goodsInfoDO.setId(goodsInfoDTO.getId());
        goodsInfoDO.setCreateTime(goodsInfoDTO.getCreateTime());
        goodsInfoDO.setUpdateTime(goodsInfoDTO.getUpdateTime());
        return goodsInfoDO;
    }

}
