package org.springframework.basics.section07

import org.springframework.basics.section07.interfaces.CacheableService
import org.springframework.basics.section07.interfaces.MyCacheHolder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.EnableAspectJAutoProxy
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification
import spock.lang.Unroll

@ContextConfiguration(classes=TestConfiguration)
class AspectJTest extends Specification  {

    @Autowired
    CacheableService cacheableService

    @Unroll
    def "cached value has to be #output"() {

        expect:

            output == cacheableService.getSophisticatedString(input)

        where:
            input | output
            "a"|"<<a>>CACHED"
            "b"|"<<b>>CACHED"
            "c"|"<<c>>"
            "d"|"<<d>>"
            "c"|"<<c>>CACHED"
            "d"|"<<d>>CACHED"
    }


    @Configuration
    @EnableAspectJAutoProxy
    @ComponentScan(basePackages="org.springframework.basics.section07")
    public static class TestConfiguration {

    }

    protected void intercept() {

        MyCacheHolder.metaClass.getCache = { String name, args ->
            println "mskdf"
            def m = delegate.metaClass.getMetaMethod(name, *args)
            (m ? m.invoke(delegate, *args) : delegate.metaClass.invokeMissingMethod(delegate, name, args))
            }
    }
}
