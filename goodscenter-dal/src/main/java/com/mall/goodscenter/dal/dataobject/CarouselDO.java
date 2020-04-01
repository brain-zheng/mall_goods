package com.mall.goodscenter.dal.dataobject;

import lombok.Data;

/**
 * @author zheng haijain
 * @createTime 2020-03-22 13:28
 * @description
 */
@Data
public class CarouselDO extends BaseDO {

    private static final long serialVersionUID = 1954358269490526282L;

    /**
     * 轮播图片url
     */
    private String carouselUrl;

    /**
     * 点击后的跳转地址(默认不跳转)
     */
    private String redirectUrl;

    /**
     * 排序值(字段越大越靠前)
     */
    private Integer carouselRank;

    /**
     * 删除标识字段(0-未删除 1-已删除)
     */
    private Byte isDeleted;

    /**
     * 拓展字段
     */
    private String feature;

}
