package com.mall.goodscenter.client.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zheng haijain
 * @createTime 2020-04-06 17:21
 * @description
 */
@Data
public class MallGoodsInfoDTO extends BaseDTO {

    private static final long serialVersionUID = 3969613024782727387L;

    private String goodsName;

    private String goodsIntro;

    private Integer goodsCategoryId;

    private String goodsCoverImg;

    private String goodsCarousel;

    private Integer originalPrice;

    private Integer sellingPrice;

    private Integer stockNum;

    private String tag;

    private Byte goodsSellStatus;

    private String goodsDetailContent;
}
