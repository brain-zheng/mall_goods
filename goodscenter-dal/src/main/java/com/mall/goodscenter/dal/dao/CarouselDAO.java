package com.mall.goodscenter.dal.dao;

import com.mall.common.service.util.PageQueryUtil;
import com.mall.goodscenter.dal.dataobject.CarouselDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zheng haijain
 * @createTime 2020-03-22 13:40
 * @description
 */
public interface CarouselDAO extends BaseDAO<CarouselDO> {

    int insertSelective(CarouselDO record);

    int updateByPrimaryKeySelective(CarouselDO record);

    List<CarouselDO> findCarouselList(PageQueryUtil pageUtil);

    int getTotalCarousels(PageQueryUtil pageUtil);

    int deleteBatch(Integer[] ids);

    int deleteByPrimaryKey(Integer carouselId);

    List<CarouselDO> findCarouselsByNum(@Param("number") int number);

}
