package com.mall.goodscenter.client.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zheng haijain
 * @createTime 2020-03-20 14:45
 * @description
 */
@Data
public class BaseDTO implements Serializable {

    private static final long serialVersionUID = -7029280631493957736L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

}
