package com.mall.goodscenter.dal.dataobject;

import lombok.Data;

/**
 * @author zheng haijain
 * @createTime 2020-04-01 16:12
 * @description
 */
@Data
public class GoodsCategoryDO extends BaseDO {

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
