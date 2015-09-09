package org.springframework.basics.section02

import org.springframework.basics.section02.impl.CGLibStyleProxyComponent
import org.springframework.basics.section01.impl.JDKDynamicStyleProxyService
import org.springframework.basics.section01.interfaces.IService
import org.springframework.basics.section02.impl.SimpleComponent
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@ContextConfiguration(classes=TestConfiguration)
class CGLibStyleProxyTest extends Specification  {

    public static final int INPUT = 3
    public static final int EXPECTED = 3

    @Autowired
    SimpleComponent someComponent


    def "do some proxy magic"() {
        expect:
            someComponent.doSomeStuff(INPUT) == EXPECTED
    }


    @Configuration
    @ComponentScan(basePackages="org.springframework.basics.section02")
    public static class TestConfiguration {

        // TODO Register the Proxy as bean
        // Hint use @Primary

    }
}
