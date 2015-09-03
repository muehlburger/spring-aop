package org.springframework.basics.section01.impl

import org.springframework.basics.section01.interfaces.IService
import org.springframework.stereotype.Service

@Service
class SimpleService implements IService{

    @Override
    int doSomeStuff(int someValue) {
        return someValue
    }
}
