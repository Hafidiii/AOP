package com.spring.aop.service;

import com.spring.aop.aspect.Loggable;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    public int sum(int a, int b){
        return a+b;
    }

    public long divide(int a, int b){
        return a/b;
    }

    @Loggable
    public Long multiply(Long a, Long b){
        return a*b;
    }

}
