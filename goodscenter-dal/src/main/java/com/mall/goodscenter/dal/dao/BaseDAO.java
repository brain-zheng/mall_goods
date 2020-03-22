package com.mall.goodscenter.dal.dao;

/**
 * @author zheng haijain
 * @createTime 2020-03-15 17:39
 * @description   通用DAO接口
 */
public interface BaseDAO<T> {

    /**
     * 创建数据
     * @param data
     * @return
     */
    Integer create(T data);

    /**
     * 全量更新
     * @param data
     * @return
     */
    Integer update(T data);

    /**
     * 根据主键Id查询
     * @param id
     * @return
     */
    T getById(Integer id);

}
