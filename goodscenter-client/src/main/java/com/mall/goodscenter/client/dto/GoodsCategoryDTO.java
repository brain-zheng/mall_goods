package com.mall.goodscenter.client.dto;

import lombok.Data;

/**
 * @author zheng haijain
 * @createTime 2020-04-01 16:52
 * @description
 */
@Data
public class GoodsCategoryDTO extends BaseDTO {

    private static final long serialVersionUID = -5978759623996746201L;

    /**
     * 分类级别
     */
    private Integer categoryLevel;

    /**
     * 父分类Id
     */
    private Integer parentId;

    /**
     * 分类名称
     */
    private String categoryName;

    /**
     * 排序值(字段越大越靠前)
     */
    private Integer categoryRank;

    /**
     * 删除标识字段(0-未删除 1-已删除)
     */
    private Integer deleted;

}
