package org.springframework.basics.section06

import org.springframework.basics.section06.interfaces.CacheableService

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.EnableAspectJAutoProxy
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification
import spock.lang.Unroll


@ContextConfiguration(classes=TestConfiguration)
class PointcutAndAdviseTest extends Specification  {

    @Autowired
    CacheableService cacheableService

    @Unroll
    def "cached value has to be"() {

        expect:

            def input = "a"
            "<<a>>INTERCEPTED" == cacheableService.getSophisticatedString(input)
    }


    @Configuration
    @EnableAspectJAutoProxy
    @ComponentScan(basePackages="org.springframework.basics.section06")
    public static class TestConfiguration {

    }

}
