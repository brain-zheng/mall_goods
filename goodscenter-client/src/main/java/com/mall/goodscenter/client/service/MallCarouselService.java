package com.mall.goodscenter.client.service;

import com.mall.common.service.util.PageQueryUtil;
import com.mall.common.service.util.PageResult;
import com.mall.goodscenter.client.dto.CarouselDTO;

/**
 * @author zheng haijain
 * @createTime 2020-03-22 14:29
 * @description
 */
public interface MallCarouselService {

    PageResult getCarouselPage(PageQueryUtil pageUtil);

    String saveCarousel(CarouselDTO carousel);

    String updateCarousel(CarouselDTO carousel);

    CarouselDTO getCarouselById(Integer id);

    Boolean deleteBatch(Integer[] ids);

}
