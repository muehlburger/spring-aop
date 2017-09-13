package org.springframework.basics.section02.impl

import org.springframework.stereotype.Component

@Component
class CGLibStyleProxyComponent extends SimpleComponent {

    @Override
    int doSomeStuff(int someValue) {
        return someValue;
    }
}
