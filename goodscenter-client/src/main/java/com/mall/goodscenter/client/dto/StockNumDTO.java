package com.mall.goodscenter.client.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class StockNumDTO implements Serializable {

    private static final long serialVersionUID = 4917552424666255272L;

    private Integer goodsId;

    private Integer goodsCount;

}
