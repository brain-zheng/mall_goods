package com.mall.goodscenterserver;

import com.mall.goodscenter.server.GoodsCenterServerApplication;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = GoodsCenterServerApplication.class)
public class BaseTest {

    @Before
    public void beforeTest() {
        System.out.println("======= start test========");
    }

    @After
    public void afterTest(){
        System.out.println("======= end test========");
    }
}
