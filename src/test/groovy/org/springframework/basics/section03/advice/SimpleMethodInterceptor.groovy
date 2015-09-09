package org.springframework.basics.section03.advice

import org.aopalliance.intercept.MethodInterceptor
import org.aopalliance.intercept.MethodInvocation


class SimpleMethodInterceptor implements MethodInterceptor {

    @Override
    Object invoke(MethodInvocation methodInvocation) throws Throwable {
        def value = 4
        try {
            value = methodInvocation.proceed()
        } catch (ignored){
             //ignore
        }
        value
    }
}
