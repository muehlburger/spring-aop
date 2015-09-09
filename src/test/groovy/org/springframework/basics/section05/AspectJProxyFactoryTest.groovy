package org.springframework.basics.section05

import org.springframework.aop.framework.Advised
import org.springframework.basics.section05.interfaces.IService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@ContextConfiguration(classes=TestConfiguration)
class AspectJProxyFactoryTest extends Specification  {

    @Autowired
    IService service

    def "Some fun with the AspectJ Prox Factory"() {
        expect:
            service instanceof Advised
    }

    @Configuration
    @ComponentScan(basePackages="org.springframework.basics.section05.impl")
    public static class TestConfiguration {

    }


}
