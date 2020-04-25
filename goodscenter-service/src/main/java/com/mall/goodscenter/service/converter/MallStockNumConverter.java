package com.mall.goodscenter.service.converter;

import com.mall.goodscenter.client.dto.StockNumDTO;
import com.mall.goodscenter.dal.dataobject.StockNumDO;

public class MallStockNumConverter {

    public static StockNumDO dto2do(StockNumDTO dto) {
        if (dto == null) {
            return null;
        }
        StockNumDO stockNumDO = new StockNumDO();
        stockNumDO.setGoodsId(dto.getGoodsId());
        stockNumDO.setGoodsCount(dto.getGoodsCount());
        return stockNumDO;
    }

    public static StockNumDTO do2dto(StockNumDO numDO) {
        if (numDO == null) {
            return null;
        }
        StockNumDTO stockNumDTO = new StockNumDTO();
        stockNumDTO.setGoodsId(numDO.getGoodsId());
        stockNumDTO.setGoodsCount(numDO.getGoodsCount());
        return stockNumDTO;
    }

}
