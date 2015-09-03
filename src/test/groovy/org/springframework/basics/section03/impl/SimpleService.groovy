package org.springframework.basics.section03.impl

import org.springframework.basics.section03.interfaces.IService

class SimpleService implements IService{

    @Override
    int doSomeStuff(int someValue) {
        return someValue
    }
}
