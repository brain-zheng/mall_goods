package com.mall.goodscenter.service.service;

import com.mall.common.service.util.PageQueryUtil;
import com.mall.common.service.util.PageResult;
import com.mall.goodscenter.client.dto.MallGoodsInfoDTO;
import com.mall.goodscenter.client.dto.MallGoodsPageDTO;
import com.mall.goodscenter.client.service.MallGoodsInfoService;
import com.mall.goodscenter.service.manager.MallGoodsInfoManager;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zheng haijain
 * @createTime 2020-04-06 17:23
 * @description
 */
@Service("MallGoodsInfoServiceImpl")
public class MallGoodsInfoServiceImpl implements MallGoodsInfoService {

    @Resource
    public MallGoodsInfoManager mallGoodsInfoManager;

    @Override
    public String saveMallGoods(MallGoodsInfoDTO goods) {
        if (goods == null) {
            return null;
        }
        return mallGoodsInfoManager.saveMallGoods(goods);
    }

    @Override
    public String updateMallGoods(MallGoodsInfoDTO goods) {
        if (goods == null) {
            return null;
        }
        return mallGoodsInfoManager.updateMallGoods(goods);
    }

    @Override
    public MallGoodsInfoDTO getById(Integer goodsId) {
        if (goodsId == null){
            return null;
        }
        return mallGoodsInfoManager.getById(goodsId);
    }

    @Override
    public PageResult getNewBeeMallGoodsPage(MallGoodsPageDTO mallGoodsPageDTO) {
        if (mallGoodsPageDTO == null) {
            return null;
        }
        return mallGoodsInfoManager.getNewBeeMallGoodsPage(mallGoodsPageDTO);
    }

    @Override
    public Boolean batchUpdateSellStatus(Integer[] ids, int sellStatus) {
        if (ids == null || ids.length < 1) {
            return null;
        }
        return mallGoodsInfoManager.batchUpdateSellStatus(ids, sellStatus) > 0;
    }

    @Override
    public PageResult searchMallGoods(PageQueryUtil pageUtil, Integer goodsCategoryId, String orderBy, String keyWord) {
        if (pageUtil == null) {
            return null;
        }
        return mallGoodsInfoManager.searchMallGoods(pageUtil, goodsCategoryId, orderBy, keyWord);
    }
}
