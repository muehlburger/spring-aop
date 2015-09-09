package org.springframework.basics.section08.impl;

import org.springframework.basics.section08.interfaces.SomeService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class SomeServiceImpl implements SomeService{

    @Override
    @Cacheable(cacheNames = "default")
    @Transactional
    public String doSomething(String value) {

        return value;

    }

}
