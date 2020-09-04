package com.spring.aop.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestServiceAop {


    @Autowired
    private TestService testService;

    @Test
    public void invokeAOPStuff() {
        long res = testService.sum(4,1);
        System.out.println("METHOD CALL --> " + res);
    }
}
