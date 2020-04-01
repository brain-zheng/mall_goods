package com.mall.goodscenter.service.converter;

import com.mall.goodscenter.client.dto.CarouselDTO;
import com.mall.goodscenter.dal.dataobject.CarouselDO;

/**
 * @author zheng haijain
 * @createTime 2020-03-22 14:51
 * @description
 */
public class MallCarouselConverter {

    public static CarouselDO carouselDTO2DO(CarouselDTO carouselDTO) {
        if (carouselDTO == null) {
            return null;
        }
        CarouselDO carouselDO = new CarouselDO();
        carouselDO.setCarouselUrl(carouselDTO.getCarouselUrl());
        carouselDO.setRedirectUrl(carouselDTO.getRedirectUrl());
        carouselDO.setCarouselRank(carouselDTO.getCarouselRank());
        carouselDO.setIsDeleted(carouselDTO.getIsDeleted());
        carouselDO.setFeature(carouselDTO.getFeature());
        carouselDO.setId(carouselDTO.getId());
        carouselDO.setCreateTime(carouselDTO.getCreateTime());
        carouselDO.setUpdateTime(carouselDTO.getUpdateTime());
        return carouselDO;
    }

    public static CarouselDTO carouselDO2DTO(CarouselDO carouselDO) {
        if (carouselDO == null) {
            return null;
        }
        CarouselDTO carouselDTO = new CarouselDTO();
        carouselDTO.setCarouselUrl(carouselDO.getCarouselUrl());
        carouselDTO.setRedirectUrl(carouselDO.getRedirectUrl());
        carouselDTO.setCarouselRank(carouselDO.getCarouselRank());
        carouselDTO.setIsDeleted(carouselDO.getIsDeleted());
        carouselDTO.setFeature(carouselDO.getFeature());
        carouselDTO.setId(carouselDO.getId());
        carouselDTO.setCreateTime(carouselDO.getCreateTime());
        carouselDTO.setUpdateTime(carouselDO.getUpdateTime());
        return carouselDTO;
    }
}
