package org.springframework.basics.section02.impl



class CGLibStyleProxyComponent extends SimpleComponent {

    @Override
    int doSomeStuff(int someValue) {
        try {
            super.doSomeStuff(someValue)
        } catch (Exception) {
            // do nothing
        } finally {
            return someValue
        }
    }
}
