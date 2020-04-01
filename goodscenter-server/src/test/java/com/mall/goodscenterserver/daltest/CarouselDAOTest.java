package com.mall.goodscenterserver.daltest;

import com.mall.common.service.util.PageQueryUtil;
import com.mall.goodscenter.dal.dao.CarouselDAO;
import com.mall.goodscenter.dal.dataobject.CarouselDO;
import com.mall.goodscenterserver.BaseTest;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zheng haijain
 * @createTime 2020-03-22 18:33
 * @description
 */
public class CarouselDAOTest extends BaseTest {

    @Resource
    private CarouselDAO carouselDAO;

    @Test
    public void getList(){
        Map<String, Object> maps = new HashMap<>();
        maps.put("page",1);
        maps.put("limit",1);
        PageQueryUtil pageQueryUtil = new PageQueryUtil(1,1);
        List<CarouselDO> res = carouselDAO.findCarouselList(pageQueryUtil);
    }



}
