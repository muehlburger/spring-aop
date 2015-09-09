package org.springframework.basics.section05.impl

import org.springframework.aop.aspectj.annotation.AspectJProxyFactory
import org.springframework.basics.section05.aspect.SimpleAspect
import org.springframework.basics.section05.interfaces.IService
import org.springframework.beans.BeanUtils
import org.springframework.beans.BeansException
import org.springframework.beans.factory.config.BeanPostProcessor
import org.springframework.core.annotation.AnnotationUtils
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service

@Component
class AspectPostProcessor implements BeanPostProcessor {

    @Override
    Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(AnnotationUtils.findAnnotation(bean.getClass(), Service)) {
            AspectJProxyFactory factory = new AspectJProxyFactory();
            factory.setTarget(bean)
//            bean.getClass().getInterfaces().each {factory.addInterface(it)}
            factory.addAspect(SimpleAspect.class)
            return factory.getProxy();
        }
        bean
    }

    @Override
    Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean
    }
}
