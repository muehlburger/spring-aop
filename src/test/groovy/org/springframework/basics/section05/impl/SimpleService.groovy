package org.springframework.basics.section05.impl

import org.springframework.basics.section05.interfaces.IService

class SimpleService implements IService{

    @Override
    int doSomeStuff(int someValue) {
        return someValue
    }
}
