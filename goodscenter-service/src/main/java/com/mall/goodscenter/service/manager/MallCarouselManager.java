package com.mall.goodscenter.service.manager;

import com.mall.common.service.util.PageQueryUtil;
import com.mall.common.service.util.PageResult;
import com.mall.goodscenter.client.dto.CarouselDTO;
import com.mall.goodscenter.client.enums.ServiceResultEnum;
import com.mall.goodscenter.dal.dao.CarouselDAO;
import com.mall.goodscenter.dal.dataobject.CarouselDO;
import com.mall.goodscenter.service.converter.MallCarouselConverter;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zheng haijain
 * @createTime 2020-03-22 14:35
 * @description
 */
@Component
public class MallCarouselManager {

    @Resource
    public CarouselDAO carouselDAO;

    public PageResult getCarouselPage(PageQueryUtil pageUtil) {
        List<CarouselDO> carousels = carouselDAO.findCarouselList(pageUtil);
        int total = carouselDAO.getTotalCarousels(pageUtil);
        List<CarouselDTO> carouselDTOS = new ArrayList<>();
        for(CarouselDO carouselDO : carousels) {
            carouselDTOS.add(MallCarouselConverter.carouselDO2DTO(carouselDO));
        }
        return new PageResult(carouselDTOS, total, pageUtil.getLimit(), pageUtil.getPage());
    }

    public String saveCarousel(CarouselDTO carouselDTO){
        CarouselDO carouselDO = MallCarouselConverter.carouselDTO2DO(carouselDTO);
        if (carouselDO == null){
            return ServiceResultEnum.CONVERTER_ERROR.getResult();
        }
        if (carouselDAO.insertSelective(carouselDO) > 0){
            return ServiceResultEnum.SUCCESS.getResult();
        } else {
            return ServiceResultEnum.DB_ERROR.getResult();
        }
    }

    public String updateCarousel(CarouselDTO carouselDTO){
        CarouselDO carouselDO = MallCarouselConverter.carouselDTO2DO(carouselDTO);
        if (carouselDO == null){
            return ServiceResultEnum.CONVERTER_ERROR.getResult();
        }
        CarouselDO temp = carouselDAO.getById(carouselDTO.getId());
        if (temp == null) {
            return ServiceResultEnum.DATA_NOT_EXIST.getResult();
        }
        int num = carouselDAO.update(temp);
        if (num > 0) {
            return ServiceResultEnum.SUCCESS.getResult();
        }
        return ServiceResultEnum.DB_ERROR.getResult();
    }

    public CarouselDTO getCarouselById(Integer id){
        CarouselDO carouselDO = carouselDAO.getById(id);
        if (carouselDO == null){
            return null;
        }
        return MallCarouselConverter.carouselDO2DTO(carouselDO);
    }

    public Boolean deleteBatch(Integer[] ids) {
        return carouselDAO.deleteBatch(ids) > 0;
    }

    public List<CarouselDTO> findCarouselsByNum(Integer num) {
        List<CarouselDO> carouselDOS = carouselDAO.findCarouselsByNum(num);
        return carouselDOS.stream().map(MallCarouselConverter::carouselDO2DTO).collect(Collectors.toList());
    }
}
