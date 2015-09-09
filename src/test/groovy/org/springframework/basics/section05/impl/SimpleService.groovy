package org.springframework.basics.section05.impl

import org.springframework.basics.section05.interfaces.IService
import org.springframework.stereotype.Service

@Service
class SimpleService implements IService{

    @Override
    Integer doSomeStuff(int someValue) {
        someValue
    }
}
