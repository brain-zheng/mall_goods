package com.mall.goodscenter.client.service;

import com.mall.common.service.util.PageQueryUtil;
import com.mall.common.service.util.PageResult;
import com.mall.goodscenter.client.dto.MallGoodsInfoDTO;
import com.mall.goodscenter.client.dto.MallGoodsPageDTO;

import java.util.List;

/**
 * @author zheng haijain
 * @createTime 2020-04-06 17:20
 * @description
 */
public interface MallGoodsInfoService {

    String saveMallGoods(MallGoodsInfoDTO goods);

    String updateMallGoods(MallGoodsInfoDTO goods);

    MallGoodsInfoDTO getById(Integer goodsId);

    PageResult getNewBeeMallGoodsPage( MallGoodsPageDTO mallGoodsPageDTO);

    Boolean batchUpdateSellStatus(Integer[] ids,int sellStatus);

}
