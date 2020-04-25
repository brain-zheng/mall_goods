package com.mall.goodscenter.dal.dao;

import com.mall.common.service.util.PageQueryUtil;
import com.mall.goodscenter.dal.dataobject.GoodsInfoDO;
import com.mall.goodscenter.dal.dataobject.GoodsInfoPageDO;
import com.mall.goodscenter.dal.dataobject.StockNumDO;
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

    List<GoodsInfoDO> findNewBeeMallGoodsListBySearch(@Param("start") Integer start,
                                                      @Param("limit")Integer limit,
                                                      @Param("goodsCategoryId") Integer goodsCategoryId,
                                                      @Param("orderBy") String orderBy,
                                                      @Param("keyword") String keyword);

    int getTotalNewBeeMallGoodsBySearch(@Param("start") Integer start,
                                        @Param("limit")Integer limit,
                                        @Param("goodsCategoryId") Integer goodsCategoryId,
                                        @Param("keyword") String keyword);


    int updateStockNum(@Param("stockNumDOS") List<StockNumDO> stockNumDOS);

}
