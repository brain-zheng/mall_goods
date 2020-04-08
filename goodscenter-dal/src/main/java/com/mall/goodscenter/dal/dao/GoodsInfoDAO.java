package com.mall.goodscenter.dal.dao;

import com.mall.goodscenter.dal.dataobject.GoodsInfoDO;
import com.mall.goodscenter.dal.dataobject.GoodsInfoPageDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zheng haijain
 * @createTime 2020-04-06 20:09
 * @description
 */
public interface GoodsInfoDAO extends BaseDAO<GoodsInfoDO> {

    List<GoodsInfoDO> findNewBeeMallGoodsList(GoodsInfoPageDO goodsInfoPageDO);

    int getTotalMallGoods(GoodsInfoPageDO goodsInfoPageDO);

    int batchUpdateSellStatus(@Param("orderIds")Integer[] orderIds, @Param("sellStatus") int sellStatus);

}
