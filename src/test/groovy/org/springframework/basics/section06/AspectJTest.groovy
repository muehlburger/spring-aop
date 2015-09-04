package org.springframework.basics.section06;

import org.springframework.basics.section02.impl.CGLibStyleProxyComponent
import org.springframework.basics.section01.impl.JDKDynamicStyleProxyService
import org.springframework.basics.section01.interfaces.IService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.EnableAspectJAutoProxy
import org.springframework.context.annotation.Primary
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification


@ContextConfiguration(classes=TestConfiguration)
class AspectJTest extends Specification  {

    public static final int INPUT = 3
    public static final int EXPECTED = 18

    @Autowired
    IService someService


    def "do some proxy magic"() {
        expect:
            someService.doSomeStuff(INPUT) == EXPECTED
    }


    @Configuration
    @EnableAspectJAutoProxy
    @ComponentScan(basePackages="org.springframework.basics.section01")
    public static class TestConfiguration {

        @Bean
        @Primary
        public IService jdkProxyService(){
            return new JDKDynamicStyleProxyService()
        }


    }
}
