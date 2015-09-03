package org.springframework.basics.section03

import org.springframework.aop.framework.ProxyFactory
import org.springframework.basics.section03.advice.SimpleMethodInterceptor
import org.springframework.basics.section03.impl.SimpleService
import org.springframework.basics.section03.interfaces.IService
import spock.lang.Specification

class BeanFactoryTest extends Specification  {


    def "do some proxy magic"() {
        expect:

            def service = new SimpleService()

            ProxyFactory factory = new ProxyFactory()
            factory.setTarget(service)
            factory.addInterface(IService)
            factory.addAdvice(new SimpleMethodInterceptor())

            IService proxyService = (IService) factory.getProxy();

            println proxyService.doSomeStuff(3)

            //service.doSomeStuff(INPUT) == EXPECTED
    }


}
