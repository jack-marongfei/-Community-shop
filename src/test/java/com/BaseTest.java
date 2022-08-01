package com;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/*用来初始化spring配置的，配置spring和junit整合，junit启动时加载springIOC容器*/
@RunWith(SpringJUnit4ClassRunner.class)
/*告诉加载两个配置文件*/
@ContextConfiguration({"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml"})
public class BaseTest {


}
