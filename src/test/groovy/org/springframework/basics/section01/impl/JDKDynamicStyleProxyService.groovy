package org.springframework.basics.section01.impl

import org.springframework.basics.section01.interfaces.IService


class JDKDynamicStyleProxyService implements IService{

    @Override
    int doSomeStuff(int someValue) {
        someValue += 3

        // TODO Call simple Service

        return someValue*3
    }
}
