package com.mall.goodscenter.service.manager;

import com.mall.common.service.util.PageResult;
import com.mall.goodscenter.client.dto.MallGoodsInfoDTO;
import com.mall.goodscenter.client.dto.MallGoodsPageDTO;
import com.mall.goodscenter.client.enums.ServiceResultEnum;
import com.mall.goodscenter.dal.dao.GoodsInfoDAO;
import com.mall.goodscenter.dal.dataobject.GoodsInfoDO;
import com.mall.goodscenter.dal.dataobject.GoodsInfoPageDO;
import com.mall.goodscenter.service.converter.MallGoodsInfoConverter;
import com.mall.goodscenter.service.converter.MallGoodsPageConverter;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

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

}
