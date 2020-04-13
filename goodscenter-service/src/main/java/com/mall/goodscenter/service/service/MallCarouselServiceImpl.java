package com.mall.goodscenter.service.service;


import com.mall.common.service.util.PageQueryUtil;
import com.mall.common.service.util.PageResult;
import com.mall.goodscenter.client.dto.CarouselDTO;
import com.mall.goodscenter.client.enums.ServiceResultEnum;
import com.mall.goodscenter.client.service.MallCarouselService;
import com.mall.goodscenter.service.manager.MallCarouselManager;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zheng haijain
 * @createTime 2020-03-22 14:33
 * @description
 */
@Service("MallCarouselServiceImpl")
public class MallCarouselServiceImpl implements MallCarouselService {

    @Resource
    private MallCarouselManager mallCarouselManager;

    @Override
    public PageResult getCarouselPage(PageQueryUtil pageUtil) {
        if (pageUtil == null) {
            return null;
        }
        return mallCarouselManager.getCarouselPage(pageUtil);
    }

    @Override
    public String saveCarousel(CarouselDTO carousel) {
        if (carousel == null) {
            return ServiceResultEnum.DTO_EQUALS_NULL_ERROR.getResult();
        }
        return mallCarouselManager.saveCarousel(carousel);
    }

    @Override
    public String updateCarousel(CarouselDTO carousel) {
        if (carousel == null) {
            return ServiceResultEnum.DTO_EQUALS_NULL_ERROR.getResult();
        }
        return mallCarouselManager.updateCarousel(carousel);
    }

    @Override
    public CarouselDTO getCarouselById(Integer id) {
        if (id == null) {
            return null;
        }
        return mallCarouselManager.getCarouselById(id);
    }

    @Override
    public Boolean deleteBatch(Integer[] ids) {
        if (ids.length < 1) {
            return false;
        }
        //删除数据
        return mallCarouselManager.deleteBatch(ids);
    }

    @Override
    public List<CarouselDTO> findCarouselsByNum(Integer num) {
        if (num <= 0) {
            return null;
        }
        return mallCarouselManager.findCarouselsByNum(num);
    }
}
