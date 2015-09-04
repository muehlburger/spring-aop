package org.springframework.basics.section05

import org.springframework.aop.aspectj.annotation.AspectJProxyFactory
import org.springframework.aop.framework.ProxyFactory
import org.springframework.basics.section05.aspect.SimpleAspect
import org.springframework.basics.section05.impl.SimpleService
import org.springframework.basics.section05.interfaces.IService
import spock.lang.Specification

class BeanFactoryTest extends Specification  {


    def "do some proxy magic"() {
        expect:

            def service = new SimpleService()


            AspectJProxyFactory factory = new AspectJProxyFactory();
            factory.setTarget(service)
            factory.addInterface(IService)
            factory.addAspect(SimpleAspect.class)

            IService proxy = factory.getProxy();
           println proxy.doSomeStuff(3)

    }


}
