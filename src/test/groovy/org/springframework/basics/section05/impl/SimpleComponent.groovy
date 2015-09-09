package org.springframework.basics.section05.impl

import org.springframework.basics.section05.interfaces.IComponent
import org.springframework.stereotype.Component

@Component
class SimpleComponent implements IComponent{

    @Override
    Integer doSomeStuff(int someValue) {
        someValue
    }
}
