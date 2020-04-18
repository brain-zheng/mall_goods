package com.mall.goodscenter.dal.dataobject;

import lombok.Data;

/**
 * @author zheng haijain
 * @createTime 2020-04-06 20:03
 * @description
 */
@Data
public class GoodsInfoDO extends BaseDO {

    private static final long serialVersionUID = 5602177214117072782L;

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
