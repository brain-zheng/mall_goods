package com.mall.goodscenter.dal.dataobject;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zheng haijain
 * @createTime 2020-04-07 19:12
 * @description
 */
@Data
public class GoodsInfoPageDO implements Serializable {

    private static final long serialVersionUID = 5208625674850473275L;

    private String goodsName;

    private Byte goodsSellStatus;

    private Date startTime;

    private Date endTime;

    private Integer start;

    private Integer limit;

    private Integer page;

    private String keyWord;

    private Integer goodsCategoryId;

    private String orderBy;

}
