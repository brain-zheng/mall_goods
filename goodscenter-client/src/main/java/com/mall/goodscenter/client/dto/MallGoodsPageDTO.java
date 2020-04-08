package com.mall.goodscenter.client.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zheng haijain
 * @createTime 2020-04-07 19:08
 * @description
 */
@Data
public class MallGoodsPageDTO implements Serializable {

    private static final long serialVersionUID = -6491135090356515418L;

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
