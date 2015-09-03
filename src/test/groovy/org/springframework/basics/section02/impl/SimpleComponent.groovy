package org.springframework.basics.section02.impl

import org.springframework.stereotype.Component

@Component
class SimpleComponent {

    int doSomeStuff(int someValue) {
        throw new RuntimeException()
    }
}
