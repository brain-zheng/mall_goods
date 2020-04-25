package com.mall.goodscenter.service.manager;

import com.mall.common.service.util.PageQueryUtil;
import com.mall.common.service.util.PageResult;
import com.mall.goodscenter.client.dto.MallGoodsInfoDTO;
import com.mall.goodscenter.client.dto.MallGoodsPageDTO;
import com.mall.goodscenter.client.dto.StockNumDTO;
import com.mall.goodscenter.client.enums.ServiceResultEnum;
import com.mall.goodscenter.dal.dao.GoodsInfoDAO;
import com.mall.goodscenter.dal.dataobject.GoodsInfoDO;
import com.mall.goodscenter.dal.dataobject.GoodsInfoPageDO;
import com.mall.goodscenter.dal.dataobject.StockNumDO;
import com.mall.goodscenter.service.converter.MallGoodsInfoConverter;
import com.mall.goodscenter.service.converter.MallGoodsPageConverter;
import com.mall.goodscenter.service.converter.MallStockNumConverter;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zheng haijain
 * @createTime 2020-04-06 20:01
 * @description
 */
@Component
public class MallGoodsInfoManager {

    @Resource
    public GoodsInfoDAO goodsInfoDAO;

    public String saveMallGoods(MallGoodsInfoDTO goods) {
        GoodsInfoDO goodsInfoDO = MallGoodsInfoConverter.dto2do(goods);
        if (goodsInfoDAO.create(goodsInfoDO) > 0) {
            return ServiceResultEnum.SUCCESS.getResult();
        }
        return ServiceResultEnum.DB_ERROR.getResult();
    }

    public String updateMallGoods(MallGoodsInfoDTO goods) {
        GoodsInfoDO temp = goodsInfoDAO.getById(goods.getId());
        if (temp == null) {
            return ServiceResultEnum.DATA_NOT_EXIST.getResult();
        }
        GoodsInfoDO goodsInfoDO = MallGoodsInfoConverter.dto2do(goods);
        if (goodsInfoDAO.update(goodsInfoDO) > 0) {
            return ServiceResultEnum.SUCCESS.getResult();
        }
        return ServiceResultEnum.DB_ERROR.getResult();
    }

    public MallGoodsInfoDTO getById(Integer goodsId) {
        GoodsInfoDO goodsInfoDO = goodsInfoDAO.getById(goodsId);
        MallGoodsInfoDTO goodsInfoDTO = MallGoodsInfoConverter.do2dto(goodsInfoDO);
        return goodsInfoDTO;
    }

    public PageResult getNewBeeMallGoodsPage(MallGoodsPageDTO mallGoodsPageDTO) {
        GoodsInfoPageDO pageDO = MallGoodsPageConverter.dto2do(mallGoodsPageDTO);
        List<GoodsInfoDO> goodsList = goodsInfoDAO.findNewBeeMallGoodsList(pageDO);
        int total = goodsInfoDAO.getTotalMallGoods(pageDO);
        PageResult pageResult = new PageResult(goodsList, total, mallGoodsPageDTO.getLimit(), mallGoodsPageDTO.getPage());
        return pageResult;
    }

    public int batchUpdateSellStatus(Integer[] ids, int sellStatus) {
        return goodsInfoDAO.batchUpdateSellStatus(ids, sellStatus);
    }

    public PageResult searchMallGoods(PageQueryUtil pageUtil, Integer goodsCategoryId, String orderBy, String keyWord) {
        List<GoodsInfoDO> goodsInfoDOS = goodsInfoDAO.findNewBeeMallGoodsListBySearch(pageUtil.getStart(), pageUtil.getLimit(), goodsCategoryId, orderBy, keyWord);
        List<MallGoodsInfoDTO> goodsInfoDTOS = goodsInfoDOS.stream().map(MallGoodsInfoConverter::do2dto).collect(Collectors.toList());
        if (!CollectionUtils.isEmpty(goodsInfoDTOS)){
            for (MallGoodsInfoDTO goodsInfoDTO : goodsInfoDTOS) {
                String goodsName = goodsInfoDTO.getGoodsName();
                String goodsIntro = goodsInfoDTO.getGoodsIntro();
                // 字符串过长导致文字超出的问题
                if (goodsName.length() > 28) {
                    goodsName = goodsName.substring(0, 28) + "...";
                    goodsInfoDTO.setGoodsName(goodsName);
                }
                if (goodsIntro.length() > 30) {
                    goodsIntro = goodsIntro.substring(0, 30) + "...";
                    goodsInfoDTO.setGoodsIntro(goodsIntro);
                }
            }
        }
        int total = goodsInfoDAO.getTotalNewBeeMallGoodsBySearch(pageUtil.getStart(), pageUtil.getLimit(), goodsCategoryId, keyWord);
        PageResult pageResult = new PageResult(goodsInfoDTOS, total, pageUtil.getLimit(), pageUtil.getPage());
        return pageResult;
    }

    public Integer updateStockNum(List<StockNumDTO> stockNumDTOS) {
        List<StockNumDO> stockNumDOS = stockNumDTOS.stream().map(MallStockNumConverter::dto2do).collect(Collectors.toList());
        return goodsInfoDAO.updateStockNum(stockNumDOS);
    }

}
