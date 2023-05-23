package cn.dev33.satoken.spring;

import cn.dev33.satoken.context.SaTokenContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


public class AutoConfigurationTest {

    public static TestBean testBean;

    private static Integer ad= 10;

    @Bean
    public TestBean getTestBean() {
        testBean = new TestBean("dc",23);
        return testBean;
    }
}
