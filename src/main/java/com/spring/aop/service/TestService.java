package com.spring.aop.service;

import org.springframework.stereotype.Service;

@Service
public class TestService {

    public int sum(int a, int b){
        return a+b;
    }

    public long divide(int a, int b){
        return a/b;
    }

    public Long multiply(Long a, Long b){
        return a*b;
    }

}
