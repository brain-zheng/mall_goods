package com.mall.goodscenterserver.daltest;

import com.mall.goodscenter.dal.dao.CarouselDAO;
import com.mall.goodscenter.dal.dataobject.CarouselDO;
import com.mall.goodscenterserver.BaseTest;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * @author zheng haijain
 * @createTime 2020-03-22 18:33
 * @description
 */
public class CarouselDAOTest extends BaseTest {

    @Resource
    private CarouselDAO carouselDAO;

    @Test
    public void testupdate(){
        CarouselDO carouselDO = new CarouselDO();
        carouselDO.setCarouselRank(100);
        carouselDO.setCarouselUrl("http://localhost:8089/upload/20200402_17181119.jpg");
        carouselDO.setFeature(null);
        carouselDO.setIsDeleted(null);
        carouselDO.setRedirectUrl("##");
        carouselDO.setId(5);
        System.out.println(carouselDAO.updateByPrimaryKeySelective(carouselDO));
    }



}
