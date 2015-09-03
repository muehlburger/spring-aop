package org.springframework.basics.section01.impl

import org.springframework.basics.section01.interfaces.IService


class JDKDynamicStyleProxyService implements IService{

    private SimpleService simpleService = new SimpleService()

    @Override
    int doSomeStuff(int someValue) {
        someValue += 3

        someValue = simpleService.doSomeStuff(someValue)

        return someValue*3
    }
}
